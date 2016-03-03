package vaquita

class Commitment {

	Money amount

	static embedded = ['amount']
	static belongsTo = [participation: Participation]
	static hasMany = [payments: Payment]

    static constraints = {
    }
}
