package vaquita

class MoneyPoolController {

    def moneyPoolService

    //new
    def create() {
    }

    //view

    def save(MoneyPoolCommand command) {

        moneyPoolService.createFixedTotalMoneyPool(command)

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
