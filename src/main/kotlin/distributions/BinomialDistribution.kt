package distributions

import base.choose
import kotlin.math.pow

open class BinomialDistribution(val numTrials: Long, val successChance: Double): DiscreteDistribution {

    init {
        if (numTrials <= 0) throw IllegalArgumentException("numTrials ($numTrials) must be positive")
        if (successChance < 0.0 || successChance > 1.0 || successChance.isNaN())
            throw IllegalArgumentException("successChange ($successChance) must be between 0 and 1")
    }

    override fun probabilityMass(score: Long): Double {
        if (score > numTrials || score < 0) return 0.0;
        return choose(numTrials, score) * successChance.pow(score.toDouble()) * (1.0 - successChance).pow((numTrials - score).toDouble())
    }

    override val expected: Double
        get() = numTrials * successChance

    override val variance: Double
        get() = numTrials * successChance * (1.0 - successChance)
}