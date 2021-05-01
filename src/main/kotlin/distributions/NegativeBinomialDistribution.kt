package distributions

import base.choose
import kotlin.math.pow

open class NegativeBinomialDistribution(val successChance: Double, val numNeededSuccesses: Long): DiscreteDistribution {

    override fun probabilityMass(score: Long): Double {
        if (score < numNeededSuccesses) {
            return 0.0
        }

        return choose(score - 1, numNeededSuccesses - 1) *
                successChance.pow(numNeededSuccesses.toDouble()) *
                (1.0 - successChance).pow((score - numNeededSuccesses).toDouble())
    }

    override val expected: Double
        get() = numNeededSuccesses / successChance

    override val variance: Double
        get() = numNeededSuccesses * (1.0 - successChance) / (successChance * successChance)
}