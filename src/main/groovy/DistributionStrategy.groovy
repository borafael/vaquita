package vaquita

import vaquita.Participation
import vaquita.Money

interface DistributionStrategy {

    Money distribute(Money total, Set<Participation> participations)
}
