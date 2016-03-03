package vaquita

import vaquita.MoneyPool
import vaquita.Participation
import grails.transaction.Transactional

@Transactional
class MoneyPoolService {

    def messageService

    def createMoneyPool(User user, MoneyPoolCommand command) {

        MoneyPool moneyPool = new MoneyPool(
            user,
            command.name,
            command.description,
            command.url,
            command.amount,
            command.type)

        moneyPool.save()

        inviteBuyer(command.buyerMail, moneyPool)
        inviteCollector(command.collectorMail, moneyPool)
        inviteParticipants(command.mails, moneyPool)
    }

    def inviteParticipants(String mails, MoneyPool moneyPool) {

        mails.split(',').each({

                inviteParticipant(it.trim(), moneyPool)
        })
    }

    def inviteBuyer(String buyerMail, MoneyPool moneyPool) {
        User recipient = User.findByMail(buyerMail)

        Invitation invitation = moneyPool.invite(recipient, ParticipantRole.BUYER)

        String message = sprintf(
            '%s lo ha invitado a a participar de de %s como %s',
            [
                invitation.sender,
                invitation.moneyPool,
                invitation.role
            ])
        //el mensaje esta dirigido de quien recibio la invitacion a quien la realizo
        messageService.send(invitation.sender, invitation.recipient, message)
    }

    def inviteCollector(String collectorMail, MoneyPool moneyPool) {
        User recipient = User.findByMail(collectorMail)

        Invitation invitation = moneyPool.invite(recipient, ParticipantRole.COLLECTOR)

        String message = sprintf(
            '%s lo ha invitado a a participar de de %s como %s',
            [
                invitation.sender,
                invitation.moneyPool,
                invitation.role
            ])

        messageService.send(invitation.sender, invitation.recipient, message)
    }

    def inviteParticipant(String mail, MoneyPool moneyPool) {

        User recipient = User.findByMail(mail)

        Invitation invitation = moneyPool.invite(recipient, ParticipantRole.PARTICIPANT)

        String message = sprintf(
            '%s lo ha invitado a a participar de de %s como %s',
            [
                invitation.sender,
                invitation.moneyPool,
                invitation.role
            ])

        messageService.send(invitation.sender, invitation.recipient, message)
    }

    def fetchMoneyPools(User participant) {

        def moneyPools = Participation.findAllByParticipant(participant).collect {
            it.moneyPool
        }

        return moneyPools
    }

    def fetchPendingInvitations(User user) {
        return Invitation.findAllByRecipientAndStatus(user, InvitationStatus.PENDING)
    }

    def fetchPendingInvitations(MoneyPool moneyPool) {
        return Invitation.findAllByMoneyPoolAndStatus(moneyPool, InvitationStatus.PENDING)
    }


    def accept(Long invitationId) {
        Invitation invitation = Invitation.findByIdAndStatus(invitationId, InvitationStatus.PENDING)
        invitation.accept()

        String message = sprintf(
            '%s a aceptado su solicitud para participar de %s como %s',
            [
                invitation.recipient.mail,
                invitation.moneyPool.name,
                invitation.role
            ])
        //el mensaje esta dirigido de quien recibio la invitacion a quien la realizo
        messageService.send(invitation.recipient, invitation.sender, message)
    }

    def reject(Long invitationId) {
        Invitation invitation = Invitation.findByIdAndStatus(invitationId, InvitationStatus.PENDING)
        invitation.reject()

        String message = sprintf(
            '%s a rechazado su solicitud para participar de %s como %s',
            [
                invitation.recipient,
                invitation.moneyPool,
                invitation.role
            ])
        //el mensaje esta dirigido de quien recibio la invitacion a quien la realizo
        messageService.send(invitation.recipient, invitation.sender, message)
    }

    def update(User user, MoneyPool moneyPool, Map parameters) {

        moneyPool.update(parameters)

        moneyPool.participations.each {

            if(it.participant != user) {
                String message = sprintf(
                    '%s ha modificado la vaquita %s',
                    [
                        user,
                        moneyPool,
                    ])

                messageService.send(user, it.participant, moneyPool, message)
            }
        }
    }
}
