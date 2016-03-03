package vaquita

class Message {

    Date date = new Date()
    User sender
    User recipient
    MoneyPool moneyPool
    String text

    static constraints = {
        moneyPool nullable: true
        recipient nullable: true
    }
}
