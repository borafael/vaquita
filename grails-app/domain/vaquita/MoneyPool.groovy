package vaquita

enum MoneyPoolType {

    //monto fijo total a repartir igualmente entre los participantes
    FIXED_TOTAL(new FixedTotalStrategy()),

    //monto fijo por persona
    FIXED_CONTRIBUTION(new FixedContributionStrategy()),

    //sin ninguna restriccion en el total o por persona
    FREE(new FreeStrategy())

    DistributionStrategy strategy

    private MoneyPoolType(DistributionStrategy strategy) {
        this.strategy = strategy
    }

    DistributionStrategy getStrategy() {
        return this.strategy
    }
}

class MoneyPool {

	String name
	String description
	String url
    Money amount
	MoneyPoolType type

    static embedded = ['amount']

    static hasMany = [participations: Participation]

    static constraints = {
    	name blank: false
    	type null: false

    }

    public MoneyPool(
        User user,
        String name,
        String description,
        String url,
        Money amount,
        MoneyPoolType type){

        this.name = name
        this.description = description
        this.url = url
        this.amount = amount
        this.type = type

        Participation participation = new Participation(
            participant: user,
            moneyPool: this,
            role: ParticipantRole.CREATOR
        )

        addParticipation(participation)
    }

    def getCreator() {
        return participations.find {it.role == ParticipantRole.CREATOR}.participant
    }

    def invite(User user, ParticipantRole role) {

        Invitation invitation = new Invitation(
            message: "blah",
            date: new Date(),
            status: InvitationStatus.PENDING,
            sender: this.getCreator(),
            recipient: user,
            moneyPool: this,
            role: role)

        invitation.save()
    }

    def distribute() {

        Money commitmentAmount = type.getStrategy().distribute(amount, participations)

        participations.each {

            if(!it.commitment) {

                it.commitment = new Commitment(participation: it)
            }

            it.commitment.amount = commitmentAmount
        }
    }

    def addParticipation(Participation participation) {
        addToParticipations(participation)

        distribute()
    }

    def update(Map parameters) {

        name = parameters.name
        description = parameters.description
        url = parameters.url
        amount = parameters.amount
        type = parameters.type

        distribute()
    }
}
