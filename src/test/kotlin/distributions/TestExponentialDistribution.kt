package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestExponentialDistribution {

    @Test
    fun testChanceBetween() {
        val dist10 = ExponentialDistribution(10.0)
        assertEquals(0.3679, dist10.chanceBetween(lowerBound = 10.0), 0.0001)
        assertEquals(0.1353, dist10.chanceBetween(lowerBound = 20.0), 0.0001)
        assertEquals(0.9502, dist10.chanceBetween(upperBound = 30.0), 0.0001)

        val dist3 = ExponentialDistribution(1.0 / 3.0)
        assertEquals(0.95, dist3.chanceBetween(upperBound = 1.0), 0.01)
        assertEquals(1.0, dist3.chanceBetween(), 0.0001)

        val dist15 = ExponentialDistribution(15.0)
        assertEquals(0.1353, dist15.chanceBetween(lowerBound = 30.0), 0.0001)
        assertEquals(0.2031, dist15.chanceBetween(5.0, 10.0), 0.0001)
    }

    @Test
    fun testProperties() {
        val dist4 = ExponentialDistribution(4.0)
        assertEquals(4.0, dist4.mean, 0.0001)
        assertEquals(16.0, dist4.variance, 0.0001)
        assertEquals(4.0, dist4.standardDeviation, 0.0001)
    }
}
