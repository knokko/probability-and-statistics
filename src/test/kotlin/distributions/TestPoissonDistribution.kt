package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestPoissonDistribution {

    @Test
    fun testProbabilityMass() {
        assertEquals(0.03783, PoissonDistribution(10.0).probabilityMass(5), 0.001)
        assertEquals(0.05165, PoissonDistribution(20.0).probabilityMass(15), 0.001)
    }

    @Test
    fun testExpectedValue() {
        assertEquals(12.3, PoissonDistribution(12.3).expectedValue, 0.00001)
    }

    @Test
    fun testVariance() {
        assertEquals(23.4, PoissonDistribution(23.4).variance, 0.00001)
    }
}
