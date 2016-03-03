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

        inviteUsers(user, command.mails, moneyPool)
    }

    def inviteUsers(User sender, String mails, MoneyPool moneyPool) {

        mails.split(',').each({

                inviteUser(sender, it.trim(), moneyPool)
        })
    }

    def inviteUser(User sender, String mail, MoneyPool moneyPool) {

        User recipient = User.findByMail(mail)

        moneyPool.invite(recipient)
    }

    def fetchMoneyPools(User participant) {

        def moneyPools = Participation.findAllByParticipant(participant).collect {
            it.moneyPool
        }

        return moneyPools
    }

    def fetchPendingInvitations(User user) {
        return Invitation.findAllByRecipientAndStatus(user,InvitationStatus.PENDING)
    }

    def accept(Long invitationId) {
        Invitation invitation = Invitation.findByIdAndStatus(invitationId, InvitationStatus.PENDING)
        invitation.accept()
    }

    def reject(Long invitationId) {
        Invitation invitation = Invitation.findByIdAndStatus(invitationId, InvitationStatus.PENDING)
        invitation.reject()
    }
}
