package vaquita

class User {

	String name

	static hasMany = [moneyPools: MoneyPool]

    static constraints = {
    	name blank: false
    }
}
