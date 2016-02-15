package vaquita

class SecurityController {

    def securityService

    def login(LoginCommand loginCommand) {

        println(loginCommand.mail)
        println(loginCommand.pass)
        securityService.login(loginCommand.mail, loginCommand.pass)
        redirect(controller: 'moneyPool', action: 'list')
    }

    def logout() {

        securityService.logout()
    }
}
