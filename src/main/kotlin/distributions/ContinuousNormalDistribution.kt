package distributions

import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sqrt

class ContinuousNormalDistribution(override val mean: Double, override val standardDeviation: Double): ContinuousDistribution(
    { x -> exp(-(x - mean).pow(2) / (2.0 * standardDeviation.pow(2))) / (standardDeviation * sqrt(2.0 * PI))}, null, null) {

    override val variance: Double
        get() = standardDeviation * standardDeviation
}

val StandardNormalDistribution = ContinuousNormalDistribution(0.0, 1.0)