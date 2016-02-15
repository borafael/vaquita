package vaquita

import grails.transaction.Transactional

@Transactional
class SecurityService {

    def login(String mail, String pass) {

        User user = new User(mail: mail, pass: pass)
        user.save()

        RequestContextHolder.currentRequestAttributes().getSession()["user"] = user
    }

    def logout() {

        RequestContextHolder.currentRequestAttributes().getSession()["user"] = null
    }
}
