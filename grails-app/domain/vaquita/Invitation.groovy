package vaquita

enum InvitationStatus {
    ACCEPTED,
    REJECTED,
    PENDING
}

class Invitation {

    Date date
    InvitationStatus status
    User sender
    User recipient
    MoneyPool moneyPool

    static constraints = {
    }
}
