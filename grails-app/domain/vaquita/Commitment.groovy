package vaquita

class Payment {
	Date date
}

class Commitment {

	static belongsTo = MoneyPool
	static hasMany = [payments: Payment]

    static constraints = {
    }
}
