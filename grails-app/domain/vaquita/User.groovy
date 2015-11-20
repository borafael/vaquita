package vaquita

class User {

	String name

<<<<<<< HEAD
	static hasMany = [participations: Participation]

=======
>>>>>>> c62f00c4850db49d822d7e0966c28f2314d19d36
    static constraints = {
    	name blank: false
    }
}
