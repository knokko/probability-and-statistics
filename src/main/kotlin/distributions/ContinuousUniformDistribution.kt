package distributions

import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class ContinuousUniformDistribution(lowerBound: Double, upperBound: Double): ContinuousDistribution({ x ->
    if (x < lowerBound || x > upperBound) { 0.0 } else { 1.0 / (upperBound - lowerBound) }
}, lowerBound, upperBound) {

    // Overriding chanceBetween, mean, and variance is not required, but improves precision and performance
    override fun chanceBetween(lowerBound: Double?, upperBound: Double?): Double {
        val combinedLowerBound = if (lowerBound == null) { this.lowerBound!! } else { max(lowerBound, this.lowerBound!!) }
        val combinedUpperBound = if (upperBound == null) { this.upperBound!! } else { min(upperBound, this.upperBound!!) }

        return  (combinedUpperBound - combinedLowerBound) / (this.upperBound - this.lowerBound)
    }

    override val mean: Double
        get() = (lowerBound!! + upperBound!!) / 2.0

    override val variance: Double
        get() = (upperBound!! - lowerBound!!).pow(2) / 12.0
}
