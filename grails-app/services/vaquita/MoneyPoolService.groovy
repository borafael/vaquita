package vaquita

import vaquita.MoneyPool
import vaquita.Participation
import grails.transaction.Transactional

@Transactional
class MoneyPoolService {

    def createMoneyPool(User user, MoneyPoolCommand command) {

        MoneyPool moneyPool = new MoneyPool(
            'name': command.name,
            'description': command.description,
            'url': command.url,
            'amount': command.amount,
            'type': command.type)

        moneyPool.save()

        Participation participation = new Participation(
            participant: user,
            moneyPool: moneyPool,
            role: ParticipantRole.CREATOR
        )

        participation.save()

        sendInvitations(user, command.mails, moneyPool)
    }

    def sendInvitations(User sender, String mails, MoneyPool moneyPool) {

        mails.split(',').each({

                sendInvitation(sender, it.trim(), moneyPool)
        })
    }

    def sendInvitation(User sender, String mail, MoneyPool moneyPool) {

        User recipient = User.findByMail(mail)
        String message = "blah"

        Invitation invitation = new Invitation(
            message: message,
            date: new Date(),
            status: InvitationStatus.PENDING,
            sender: sender,
            recipient: recipient,
            moneyPool: moneyPool)

        invitation.save()
    }

    def fetchMoneyPools(User participant) {

        def moneyPools = Participation.findAllByParticipant(participant).collect {
            it.moneyPool
        }

        return moneyPools
    }

    def accept(Long invitationId) {
        Invitation invitation = Invitation.findByIdAndStatus(invitationId, InvitationStatus.PENDING)
        invitation.setStatus(InvitationStatus.ACCEPTED)

        Participation participation = new Participation(
            participant: invitation.recipient,
            moneyPool: invitation.moneyPool,
            role: ParticipantRole.PARTICIPANT
        )

        participation.save()
    }

    def reject(Long invitationId) {
        Invitation invitation = Invitation.findByIdAndStatus(invitationId, InvitationStatus.PENDING)
        invitation.setStatus(InvitationStatus.REJECTED)
    }
}
