package vaquita

import vaquita.MoneyPool
import vaquita.Participation
import grails.transaction.Transactional

@Transactional
class MoneyPoolService {

    def createMoneyPool(User user, MoneyPoolCommand command) {

        println('creando...')

        MoneyPool moneyPool = new MoneyPool(
            user,
            command.name,
            command.description,
            command.url,
            command.amount,
            command.type)

        moneyPool.save()

        println(moneyPool.errors)

        inviteUsers(user, command.mails, moneyPool)
    }

    def inviteUsers(User sender, String mails, MoneyPool moneyPool) {

        mails.split(',').each({

                inviteUser(sender, it.trim(), moneyPool)
        })
    }

    def inviteUser(User sender, String mail, MoneyPool moneyPool) {

        User recipient = User.findByMail(mail)

//        moneyPool.invite(recipient)
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
