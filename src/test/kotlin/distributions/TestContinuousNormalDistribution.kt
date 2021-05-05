package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestContinuousNormalDistribution {

    @Test
    fun testChanceBetween() {
        val standard = ContinuousNormalDistribution(0.0, 1.0)
        assertEquals(0.9066, standard.chanceBetween(upperBound = 1.32), 0.001)
        assertEquals(0.9987, standard.chanceBetween(upperBound = 3.0), 0.001)
        assertEquals(0.0735, standard.chanceBetween(lowerBound = 1.45), 0.001)
        assertEquals(0.9512, standard.chanceBetween(-2.34, 1.76), 0.001)
        assertEquals(1.0, standard.chanceBetween(), 0.001)

        val custom1 = ContinuousNormalDistribution(10.0, 2.0)
        assertEquals(0.9332, custom1.chanceBetween(upperBound = 13.0), 0.001)
        assertEquals(0.6915, custom1.chanceBetween(lowerBound = 9.0), 0.001)
        assertEquals(0.1587, custom1.chanceBetween(-2.0, 8.0), 0.001)
        assertEquals(1.0, custom1.chanceBetween(), 0.001)
    }

    @Test
    fun testProperties() {
        val standard = ContinuousNormalDistribution(0.0, 1.0)
        assertEquals(0.0, standard.mean, 0.001)
        assertEquals(1.0, standard.variance, 0.001)
        assertEquals(1.0, standard.standardDeviation, 0.001)

        val custom1 = ContinuousNormalDistribution(10.0, 2.0)
        assertEquals(10.0, custom1.mean, 0.001)
        assertEquals(4.0, custom1.variance, 0.001)
        assertEquals(2.0, custom1.standardDeviation, 0.001)
    }
}
