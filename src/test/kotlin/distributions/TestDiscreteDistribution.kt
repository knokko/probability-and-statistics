package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestDiscreteDistribution {

    @Test
    fun testProbabilityMass() {
        assertEquals(0.2381, PoissonDistribution(4.0).probabilityMass(0L..2), 0.0001)
        assertEquals(0.2381, PoissonDistribution(4.0).probabilityMass(0L..2L), 0.0001)
        assertEquals(0.2381, PoissonDistribution(4.0).probabilityMass(0..2), 0.0001)
        assertEquals(0.21979, PoissonDistribution(4.0).probabilityMass(1..2), 0.0001)
    }

    @Test
    fun testStandardDeviation() {
        assertEquals(0.4, BernoulliDistribution(0.8).standardDeviation, 0.001)
    }
}
