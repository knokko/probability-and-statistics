package distributions

interface DiscreteDistribution {

    fun probabilityMass(numSuccesses: Long): Double

    val expected: Double

    val variance: Double
}
