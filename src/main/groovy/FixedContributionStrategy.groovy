package vaquita

import vaquita.Participation
import vaquita.Money

class FixedContributionStrategy implements DistributionStrategy {

    Money distribute(Money total, Set<Participation> participations) {
        return total
    }
}
