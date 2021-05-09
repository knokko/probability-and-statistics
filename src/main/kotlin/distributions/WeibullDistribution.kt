package distributions

import base.computeBoundedIntegral
import base.computeIntegral
import kotlin.math.exp
import kotlin.math.pow

class WeibullDistribution(val shape: Double, val scale: Double): ContinuousDistribution({ x ->
    if (x > 0.0) { (shape / scale) * (x / scale).pow(shape - 1.0) * exp(-(x / scale).pow(shape)) } else { 0.0 }
}, 0.0) {

    override fun chanceBetween(lowerBound: Double?, upperBound: Double?): Double {
        val lowerValue = if (lowerBound == null || lowerBound <= 0.0 ) { 0.0 } else { 1.0 - exp(-(lowerBound / scale).pow(shape)) }
        val upperValue = if (upperBound == null) { 1.0 } else { 1.0 - exp(-(upperBound / scale).pow(shape)) }
        return upperValue - lowerValue
    }

    // Overriding the mean and variance like this counters some floating point inaccuracy problems
    override val mean: Double by lazy {
        val meanFunction = { x: Double -> x * f(x) };
        computeIntegral(meanFunction, 0.0, scale) +
                computeBoundedIntegral(meanFunction, scale, scale * 5.0, 1_000_000) +
                computeIntegral(meanFunction, scale * 5.0, scale * 25.0)
    }

    override val variance: Double by lazy {
        val varianceFunction = { x: Double -> (x - mean) * (x - mean) * f(x) };
        computeIntegral(varianceFunction, 0.0, scale) +
                computeBoundedIntegral(varianceFunction, scale, scale * 5.0, 1_000_000) +
                computeIntegral(varianceFunction, scale * 5.0)
    }
}
