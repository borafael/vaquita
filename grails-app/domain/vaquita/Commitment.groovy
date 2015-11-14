package vaquita

class Commitment {

	MoneyPool moneyPool

	static belongsTo = MoneyPool
	static hasMany = [payments: Payment]

    static constraints = {
    }
}