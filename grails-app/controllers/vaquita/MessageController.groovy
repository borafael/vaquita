package vaquita

class MessageController {

    def messageService

    def list() {
        User user = session.user
        Message[] messages = messageService.fetchMessages(user)

        [messages: messages]
    }
}
