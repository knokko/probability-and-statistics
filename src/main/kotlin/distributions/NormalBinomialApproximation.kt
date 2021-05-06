package distributions

import kotlin.math.sqrt

/**
 * An approximation of the (discrete) binomial distribution using a continuous normal distribution.
 */
class NormalBinomialApproximation(numTrials: Long, successChance: Double): BinomialDistribution(numTrials, successChance) {

    private fun toStandard(original: Double): Double {
        return (original - numTrials * successChance) / (sqrt(numTrials * successChance * (1.0 - successChance)))
    }

    // It must be overridden because the default implementation is too expensive
    override fun probabilityMass(score: Long): Double {
        val lowerBound = toStandard(score - 0.5)
        val upperBound = toStandard(score + 0.5)
        return StandardNormalDistribution.chanceBetween(lowerBound, upperBound)
    }

    override fun probabilityMass(scores: IntRange): Double {
        return if (scores.step == 1) {
            val lowerBound = toStandard(scores.first - 0.5)
            val upperBound = toStandard(scores.last + 0.5)
            StandardNormalDistribution.chanceBetween(lowerBound, upperBound)
        } else {
            super.probabilityMass(scores)
        }
    }

    override fun probabilityMass(scores: LongRange): Double {
        return if (scores.step == 1L) {
            val lowerBound = toStandard(scores.first - 0.5)
            val upperBound = toStandard(scores.last + 0.5)
            StandardNormalDistribution.chanceBetween(lowerBound, upperBound)
        } else {
            super.probabilityMass(scores)
        }
    }
}
