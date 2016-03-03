package vaquita

import vaquita.MoneyPool
import vaquita.Participation
import grails.transaction.Transactional

@Transactional
class MoneyPoolService {

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

        moneyPool.invite(recipient, ParticipantRole.BUYER)
    }

    def inviteCollector(String collectorMail, MoneyPool moneyPool) {
        User recipient = User.findByMail(collectorMail)

        moneyPool.invite(recipient, ParticipantRole.COLLECTOR)
    }

    def inviteParticipant(String mail, MoneyPool moneyPool) {

        User recipient = User.findByMail(mail)

        moneyPool.invite(recipient, ParticipantRole.PARTICIPANT)
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
    }

    def reject(Long invitationId) {
        Invitation invitation = Invitation.findByIdAndStatus(invitationId, InvitationStatus.PENDING)
        invitation.reject()
    }

    def update(MoneyPool moneyPool, Map parameters) {

        moneyPool.update(parameters)
    }
}
