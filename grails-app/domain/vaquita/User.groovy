package vaquita

class User {

	String name

	static hasMany = [participations: Participation]

    static constraints = {
    	name blank: false
    }
}
