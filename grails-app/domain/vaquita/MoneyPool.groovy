package vaquita

enum MoneyPoolType {
}

class MoneyPool {

	String name
	String description
	String url
	MoneyPoolType type

    static hasMany = [participations: Participation]

    static constraints = {
    	name blank: false
    	type null: false
    }
}
