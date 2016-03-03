package vaquita

import grails.transaction.Transactional

@Transactional
class MessageService {

    def send(User sender, MoneyPool moneyPool, String text) {

        new Message(sender: sender, moneyPool: moneyPool, text: text).save()
    }

    def send(User sender, User recipient, String text) {

        new Message(sender: sender, recipient: recipient, text: text).save()
    }

    def send(User sender, User recipient, MoneyPool moneyPool, String text) {

        new Message(sender: sender, recipient: recipient, moneyPool: moneyPool, text: text).save()
    }

    def fetchMessages(User user) {

        Message[] messages = Message.findAllByRecipient(user)

        messages.sort {
            it.date
        }

        return messages
    }
}
