package distributions

import base.choose

class HyperGeometricDistribution(val numElements: Long, val numGoodElements: Long, val numTakenElements: Long): DiscreteDistribution {

    init {
        if (numGoodElements > numElements)
            throw IllegalArgumentException("The number of good elements ($numGoodElements) can be at most the number of elements ($numElements)")
        if (numTakenElements > numElements)
            throw IllegalArgumentException("The number of taken elements ($numTakenElements) can be at most the number of elements ($numElements)")
    }

    override fun probabilityMass(score: Long): Double {
        if (score > numGoodElements)
            return 0.0;
        if (numTakenElements - score > numElements - numGoodElements)
            return 0.0;

        return choose(numGoodElements, score).toDouble() *
                choose(numElements - numGoodElements, numTakenElements - score).toDouble() /
                choose(numElements, numTakenElements).toDouble()
    }

    override val expected: Double
        get() = numTakenElements.toDouble() * numGoodElements.toDouble() / numElements.toDouble()

    override val variance: Double
        get() = (numTakenElements * numGoodElements * (numElements - numTakenElements) * (numElements - numGoodElements)).toDouble() /
                (numElements * numElements * (numElements - 1)).toDouble()
}