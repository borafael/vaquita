package vaquita

class User {

	String mail
	String pass

	static hasMany = [participations: Participation]

    static constraints = {
    }

}
