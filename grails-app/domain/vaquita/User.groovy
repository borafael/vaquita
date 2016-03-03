package vaquita

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes = 'mail')
class User {

	String mail
	String pass

	static hasMany = [participations: Participation]

    static constraints = {
    }

	String toString() {
		return mail
	}
}
