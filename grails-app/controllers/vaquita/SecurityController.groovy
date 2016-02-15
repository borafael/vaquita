package vaquita

class SecurityController {

    def securityService

    def login(LoginCommand loginCommand) {

        User user = securityService.login(loginCommand.mail, loginCommand.pass)

        session['user'] = user

        redirect(controller: 'moneyPool', action: 'list')
    }

    def logout() {

        session['user'] = null
    }
}
