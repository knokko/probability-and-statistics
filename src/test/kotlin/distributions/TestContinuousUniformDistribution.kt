package distributions

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.sqrt

class TestContinuousUniformDistribution {

    @Test
    fun testChanceBetween() {
        val dist1 = ContinuousUniformDistribution(-1.0, 1.0)
        assertEquals(0.9, dist1.chanceBetween(-0.9, 0.9), 0.001)

        val dist2 = ContinuousUniformDistribution(0.2050, 0.2150)
        assertEquals(0.25, dist2.chanceBetween(lowerBound = 0.2125), 0.001)
        assertEquals(0.1, dist2.chanceBetween(lowerBound = 0.2140), 0.001)
        assertEquals(0.1, dist2.chanceBetween(upperBound = 0.2060), 0.001)
        assertEquals(1.0, dist2.chanceBetween(), 0.001)
    }

    @Test
    fun testProperties() {
        val dist1 = ContinuousUniformDistribution(-1.0, 1.0)
        assertEquals(0.0, dist1.mean, 0.001)
        assertEquals(1.0 / 3.0, dist1.variance, 0.001)
        assertEquals(1.0 / sqrt(3.0), dist1.standardDeviation, 0.001)

        val dist2 = ContinuousUniformDistribution(0.2050, 0.2150)
        assertEquals(0.21, dist2.mean, 0.001)
        assertEquals(0.000008333, dist2.variance, 0.000001)
    }
}
