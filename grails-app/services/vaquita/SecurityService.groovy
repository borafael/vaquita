package vaquita

import grails.transaction.Transactional

@Transactional
class SecurityService {

    def login(String mail, String pass) {
        println(mail)
        println(pass)
        return User.findByMailAndPass(mail, pass)
    }

    def logout() {

    }
}
