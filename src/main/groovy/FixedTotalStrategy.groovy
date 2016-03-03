package vaquita

import vaquita.Participation
import vaquita.Money

class FixedTotalStrategy implements DistributionStrategy {

    Money distribute(Money total, Set<Participation> participations) {
        return total.divide(participations.size())
    }
}
