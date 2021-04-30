package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestBernoulliDistribution {

    @Test
    fun testProbabilityMass() {
        assertEquals(0.2, BernoulliDistribution(0.2).probabilityMass(1), 0.001)
        assertEquals(0.8, BernoulliDistribution(0.2).probabilityMass(0), 0.001)
    }

    @Test
    fun testExpected() {
        assertEquals(0.1, BernoulliDistribution(0.1).expected, 0.001)
    }

    @Test
    fun testVariance() {
        assertEquals(0.8 * 0.2, BernoulliDistribution(0.8).variance, 0.001)
    }
}