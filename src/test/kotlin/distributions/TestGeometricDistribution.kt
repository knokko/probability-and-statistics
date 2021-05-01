package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestGeometricDistribution {

    @Test
    fun testProbabilityMass() {
        assertEquals(0.144, GeometricDistribution(0.4).probabilityMass(3), 0.001)
    }

    @Test
    fun testExpected() {
        assertEquals(1.111111, GeometricDistribution(0.9).expected, 0.001)
    }

    @Test
    fun testVariance() {
        assertEquals(0.61224, GeometricDistribution(0.7).variance, 0.001)
    }
}