package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestUniformDistribution {

    @Test
    fun testProbabilityMass() {
        assertEquals(0.2, DiscreteUniformDistribution(3, 7).probabilityMass(3), 0.001)
        assertEquals(0.0, DiscreteUniformDistribution(3, 7).probabilityMass(2), 0.001)
    }

    @Test
    fun testExpected() {
        assertEquals(5.0, DiscreteUniformDistribution(3, 7).expected, 0.001)
        assertEquals(5.5, DiscreteUniformDistribution(3, 8).expected, 0.001)
    }

    @Test
    fun testVariance() {
        assertEquals(8.25, DiscreteUniformDistribution(10, 19).variance, 0.001)
    }
}
