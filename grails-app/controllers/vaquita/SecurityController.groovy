package vaquita

class SecurityController {

    def securityService

    def logIn(LoginCommand loginCommand) {

        User user = securityService.login(loginCommand.mail, loginCommand.pass)

        session['user'] = user

        redirect(controller: 'message', action: 'list')
    }

    def logOut() {

        session['user'] = null

        redirect(uri:'/')
    }
}
