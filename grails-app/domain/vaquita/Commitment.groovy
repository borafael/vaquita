package vaquita

class Commitment {

	Money amount = new Money(amount: 0, currency: Currency.ARS)

	static embedded = ['amount']
	static belongsTo = [participation: Participation]
	static hasMany = [payments: Payment]

    static constraints = {
    }
}
