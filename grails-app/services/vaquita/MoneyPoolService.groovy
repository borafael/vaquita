package vaquita

import vaquita.MoneyPool
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

        sendInvitations(user, command.mails, moneyPool)
    }

    def sendInvitations(User sender, String mails, MoneyPool moneyPool) {

        mails.split(',').each({

                sendInvitation(sender, it.trim(), moneyPool)
        })
    }

    def sendInvitation(User sender, String mail, MoneyPool moneyPool) {
        println("sending invitation to ${mail}")

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
}
