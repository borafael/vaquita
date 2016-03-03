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
    ParticipantRole role

    static belongsTo = [moneyPool: MoneyPool]

    static constraints = {
    }

    def accept() {

        setStatus(InvitationStatus.ACCEPTED)

        Participation participation = new Participation(
            participant: recipient,
            moneyPool: moneyPool,
            role: role
        )

        participation.save()

        moneyPool.addParticipation(participation)
    }

    def reject() {

        setStatus(InvitationStatus.REJECTED)
    }
}
