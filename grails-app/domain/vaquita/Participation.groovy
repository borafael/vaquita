package vaquita

enum ParticipantRole {
	CREATOR,
	COLLECTOR,
	BUYER,
	PARTICIPANT
}

class Participation {

	ParticipantRole role

	static hasOne = [participant: User, moneyPool: MoneyPool, commitment: Commitment]

    static constraints = {
    }
}
