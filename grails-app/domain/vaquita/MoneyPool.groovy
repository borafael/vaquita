package vaquita

enum MoneyPoolType {

    //monto fijo total a repartir igualmente entre los participantes
    FIXED_TOTAL,

    //monto fijo por persona
    FIXED_CONTRIBUTION,

    //sin ninguna restriccion en el total o por persona
    FREE
}

class MoneyPool {

	String name
	String description
	String url
    Money amount
	MoneyPoolType type

    static embedded = ['amount']

    static hasMany = [participations: Participation]

    static constraints = {
    	name blank: false
    	type null: false
    }
}
