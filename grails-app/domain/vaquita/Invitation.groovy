package vaquita

enum InvitationStatus {
    ACCEPTED,
    REJECTED,
    PENDING

}

class Invitation {

    String message
    Date date
    InvitationStatus status
    User sender
    User recipient

    static belongsTo = [moneyPool: MoneyPool]

    static constraints = {
    }

    public Invitation(String message, Date date, InvitationStatus status, User sender, User recipient, MoneyPool moneyPool) {


    }
}
