package vaquita

import vaquita.MoneyPool
import grails.transaction.Transactional

@Transactional
class MoneyPoolService {

    def createMoneyPool(MoneyPoolCommand command) {

        MoneyPool moneyPool = new MoneyPool(
            'name': command.name,
            'description': command.description,
            'url': command.url,
            'amount': command.amount,
            'type': command.type)

        moneyPool.save()

        sendInvitations(command.mails, moneyPool)
    }

    def sendInvitations(String mails, MoneyPool moneyPool) {

        mails.split(',').each({

                sendInvitation(it.trim(), moneyPool)
        })
    }

    def sendInvitation(String mail, MoneyPool moneyPool) {
        println("sending invitation to ${mail}")
/*
        User sender
        User recipient
        String message = "blah"

        Invitation invitation = new Invitation(message, new Date(), InvitationStatus.PENDING, sender, recipient, moneyPool)
        invitation.save()
        */
    }
}
