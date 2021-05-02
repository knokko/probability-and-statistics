package distributions

import base.factorial
import kotlin.math.exp
import kotlin.math.pow

class PoissonDistribution(val expectedValue: Double): DiscreteDistribution {

    override fun probabilityMass(score: Long): Double {
        return exp(-expectedValue) * expectedValue.pow(score.toDouble()) / factorial(score)
    }

    override val expected: Double
        get() = expectedValue

    override val variance: Double
        get() = expectedValue
}
