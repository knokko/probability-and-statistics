package distributions

import kotlin.math.sqrt

interface DiscreteDistribution {

    fun probabilityMass(score: Long): Double

    fun probabilityMass(scores: LongRange): Double {
        var result = 0.0
        for (score in scores) {
            result += probabilityMass(score)
        }

        return result
    }

    fun probabilityMass(scores: IntRange): Double {
        var result = 0.0
        for (score in scores) {
            result += probabilityMass(score.toLong())
        }

        return result
    }

    val expected: Double

    val variance: Double

    val standardDeviation: Double
        get() = sqrt(variance)
}
