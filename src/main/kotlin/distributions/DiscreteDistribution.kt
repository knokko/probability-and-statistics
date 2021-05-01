package distributions

interface DiscreteDistribution {

    fun probabilityMass(score: Long): Double

    val expected: Double

    val variance: Double
}
