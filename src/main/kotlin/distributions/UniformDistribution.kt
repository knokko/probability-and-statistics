package distributions

import kotlin.math.pow

class UniformDistribution(val minValue: Long, val maxValue: Long): DiscreteDistribution {

    override fun probabilityMass(score: Long): Double {
        return if (score in minValue..maxValue) {
            1.0 / (1.0 + maxValue - minValue)
        } else {
            0.0;
        }
    }

    override val expected: Double
        get() = (maxValue + minValue) / 2.0

    override val variance: Double
        get() = ((1.0 + maxValue - minValue).pow(2) - 1) / 12.0
}
