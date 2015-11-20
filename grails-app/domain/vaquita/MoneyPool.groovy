package vaquita

enum MoneyPoolType {
}

class MoneyPool {

	String name
	String description
	String url
	MoneyPoolType type
<<<<<<< HEAD

    static hasMany = [participations: Participation]
=======
>>>>>>> c62f00c4850db49d822d7e0966c28f2314d19d36

    static constraints = {
    	name blank: false
    	type null: false
    }
}
