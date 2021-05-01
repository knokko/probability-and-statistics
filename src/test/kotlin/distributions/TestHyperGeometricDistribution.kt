package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestHyperGeometricDistribution {

    @Test
    fun testProbabilityMass() {
        assertEquals(0.4191, HyperGeometricDistribution(100, 20, 4).probabilityMass(1), 0.001)
        assertEquals(0.0022, HyperGeometricDistribution(40, 34, 6).probabilityMass(2), 0.001)
    }

    @Test
    fun testExpected() {
        assertEquals(2.8, HyperGeometricDistribution(10, 4, 7).expected, 0.001)
    }

    @Test
    fun testVariance() {
        assertEquals(0.56, HyperGeometricDistribution(10, 4, 7).variance, 0.001)
    }
}