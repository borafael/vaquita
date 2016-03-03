package vaquita

class MoneyPoolController {

    def moneyPoolService

    //new
    def create() {
    }

    def edit() {

        [moneyPool: MoneyPool.get(params.id)]
    }

    def view() {

        [moneyPool: MoneyPool.get(params.id)]
    }

    def save(MoneyPoolCommand command) {

        User user = session['user']

        moneyPoolService.createMoneyPool(user, command)

        redirect(action: 'list')
    }

    def update(MoneyPoolCommand command) {

        MoneyPool moneyPool = MoneyPool.get(command.id)

        moneyPool.name = command.name
        moneyPool.description = command.description
        moneyPool.url = command.url
        moneyPool.amount = command.amount
        moneyPool.type = command.type

        redirect(action: 'list')
    }

    def list() {

        User user = session.user

        def moneyPools = moneyPoolService.fetchMoneyPools(user)
        def invitations = moneyPoolService.fetchPendingInvitations(user)

        [
            moneyPools: moneyPools,
            invitations: invitations
        ]
    }

    def delete() {
        MoneyPool.get(params.id).delete()
        redirect(action: 'list')
    }

    def accept(){

        moneyPoolService.accept(params.long('id'))
        redirect(action:'list')
    }

    def reject(){

        moneyPoolService.reject(params.long('id'))
        redirect(action:'list')
    }
}
