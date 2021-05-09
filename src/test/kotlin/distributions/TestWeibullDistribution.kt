package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestWeibullDistribution {

    @Test
    fun testChanceBetween() {
        val dist = WeibullDistribution(2.0, 10_000.0)
        assertEquals(0.4727, dist.chanceBetween(upperBound = 8_000.0), 0.001)
    }

    @Test
    fun testMean() {
        val dist = WeibullDistribution(2.0, 10_000.0)
        assertEquals(8862.2693, dist.mean, 0.1)
    }
}
