package vaquita

enum MoneyPoolType {
}

class MoneyPool {

	String name
	String description
	String url
	MoneyPoolType type

    static constraints = {
    	name blank: false
    	type null: false
    }
}
