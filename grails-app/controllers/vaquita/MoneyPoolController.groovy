package vaquita

class MoneyPoolController {

    def moneyPoolService

    //new
    def create() {
    }

    def edit() {

        User user = session.user

        MoneyPool moneyPool = MoneyPool.get(params.id)
        Invitation[] pendingInvitations = moneyPoolService.fetchPendingInvitations(moneyPool)

        [
            moneyPool: moneyPool,
            pendingInvitations: pendingInvitations
        ]
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

        User user = session.user

        MoneyPool moneyPool = MoneyPool.get(command.id)

        Map parameters = [
            name: command.name,
            description: command.description,
            url: command.url,
            amount: command.amount,
            type: command.type
        ]

        moneyPoolService.update(
            user,
            moneyPool,
            parameters
        )

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
