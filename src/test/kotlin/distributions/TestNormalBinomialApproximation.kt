package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestNormalBinomialApproximation {

    @Test
    fun testProbabilityMass() {
        val approximation1 = NormalBinomialApproximation(200, 0.4)
        assertEquals(0.085, approximation1.probabilityMass(0..70), 0.001)
        assertEquals(0.085, approximation1.probabilityMass(0L..70), 0.001)

        assertEquals(0.8294, approximation1.probabilityMass(71 until 90), 0.01)
        assertEquals(0.0575, approximation1.probabilityMass(80), 0.001)

        val approximation2 = NormalBinomialApproximation(1000, 0.02)
        assertEquals(0.1075, approximation2.probabilityMass(26 .. 100), 0.01)
        assertEquals(0.4402, approximation2.probabilityMass(21 until 30), 0.01)
    }
}