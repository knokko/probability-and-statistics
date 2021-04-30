package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestBinomialDistribution {

    @Test
    fun testProbabilityMass() {
        assertEquals(0.215, BinomialDistribution(10, 0.4).probabilityMass(3), 0.001)
        assertEquals(0.0112, BinomialDistribution(10, 0.1).probabilityMass(4), 0.001)
    }

    @Test
    fun testExpected() {
        assertEquals(30.0, BinomialDistribution(100, 0.3).expected, 0.001)
    }

    @Test
    fun testVariance() {
        assertEquals(24.0, BinomialDistribution(100, 0.6).variance, 0.001)
    }
}