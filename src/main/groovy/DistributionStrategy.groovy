package vaquita

import vaquita.Participation
import vaquita.Money

interface DistributionStrategy {

    def distribute(Money total, Set<Participation> participations)
}
