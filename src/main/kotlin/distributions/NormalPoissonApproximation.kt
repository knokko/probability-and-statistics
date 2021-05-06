package distributions

import kotlin.math.sqrt

/**
 * An approximation of the (discrete) poisson distribution using a continuous normal distribution
 */
class NormalPoissonApproximation(expectedValue: Double): PoissonDistribution(expectedValue) {

    private fun convertToStandard(original: Double): Double {
        return (original - expectedValue) / sqrt(expectedValue)
    }

    override fun probabilityMass(score: Long): Double {
        val lowerBound = convertToStandard(score - 0.5)
        val upperBound = convertToStandard(score + 0.5)
        return StandardNormalDistribution.chanceBetween(lowerBound, upperBound)
    }

    override fun probabilityMass(scores: IntRange): Double {
        return if (scores.step == 1) {
            val lowerBound = convertToStandard(scores.first - 0.5)
            val upperBound = convertToStandard(scores.last + 0.5)
            StandardNormalDistribution.chanceBetween(lowerBound, upperBound)
        } else {
            super.probabilityMass(scores)
        }
    }

    override fun probabilityMass(scores: LongRange): Double {
        return if (scores.step == 1L) {
            val lowerBound = convertToStandard(scores.first - 0.5)
            val upperBound = convertToStandard(scores.last + 0.5)
            StandardNormalDistribution.chanceBetween(lowerBound, upperBound)
        } else {
            super.probabilityMass(scores)
        }
    }
}
