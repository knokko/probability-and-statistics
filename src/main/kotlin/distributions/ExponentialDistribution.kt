package distributions

import kotlin.math.exp

// In comparison to the book: mean = 1 / lambda
class ExponentialDistribution(override val mean: Double): ContinuousDistribution(
    { x -> exp(-x / mean) / mean}, 0.0
) {

    override fun chanceBetween(lowerBound: Double?, upperBound: Double?): Double {
        return if (lowerBound == null) {
            if (upperBound == null) {
                1.0;
            } else {
                1.0 - exp(-upperBound / mean)
            }
        } else {
            if (upperBound == null) {
                exp(-lowerBound / mean)
            } else {
                exp(-lowerBound / mean) - exp(-upperBound / mean)
            }
        }
    }

    override val variance: Double
        get() = mean * mean

    override val standardDeviation: Double
        get() = mean
}
