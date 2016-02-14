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

        moneyPoolService.createFixedTotalMoneyPool(command)

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

        [moneyPools: MoneyPool.all]
    }

    def delete() {
        MoneyPool.get(params.id).delete()

        redirect(action: 'list')
    }
}
