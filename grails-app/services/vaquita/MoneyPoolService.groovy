package vaquita

import vaquita.MoneyPool
import grails.transaction.Transactional

@Transactional
class MoneyPoolService {

    def createFixedTotalMoneyPool(MoneyPoolCommand command) {

        MoneyPool moneyPool = new MoneyPool(
            'name': command.name,
            'description': command.description,
            'url': command.url,
            'amount': command.amount,
            'type': command.type)

        moneyPool.save()
    }

    def createFixedContributionMoneyPool() {

    }

    def createFreeMoneyPool() {

    }
}
