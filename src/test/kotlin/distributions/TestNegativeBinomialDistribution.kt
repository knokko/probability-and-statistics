package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestNegativeBinomialDistribution {

    @Test
    fun testProbabilityMass() {
        assertEquals(0.0, NegativeBinomialDistribution(0.8, 2).probabilityMass(1), 0.001)
        assertEquals(0.64, NegativeBinomialDistribution(0.8, 2).probabilityMass(2), 0.001)
        assertEquals(0.256, NegativeBinomialDistribution(0.8, 2).probabilityMass(3), 0.001)
        assertEquals(0.0768, NegativeBinomialDistribution(0.8, 2).probabilityMass(4), 0.001)
    }

    @Test
    fun testExpected() {
        assertEquals(20.0, NegativeBinomialDistribution(0.25, 5).expected, 0.001)
    }

    @Test
    fun testVariance() {
        assertEquals(23.333333, NegativeBinomialDistribution(0.3, 3).variance, 0.001)
    }
}