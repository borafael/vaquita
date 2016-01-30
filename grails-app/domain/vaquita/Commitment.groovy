package vaquita

class Commitment {

	static belongsTo = [participation: Participation]
	static hasMany = [payments: Payment]

    static constraints = {
    }
}
