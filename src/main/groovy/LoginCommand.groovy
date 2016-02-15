package vaquita

import grails.validation.Validateable


class LoginCommand implements Validateable {

    String mail
    String pass

    static constraints = {
        mail blank: false
        pass blank: false
    }
}
