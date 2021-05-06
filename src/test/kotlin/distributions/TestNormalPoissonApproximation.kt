package distributions

import org.junit.Assert.assertEquals
import org.junit.Test

class TestNormalPoissonApproximation {

    @Test
    fun testProbabilityMass() {
        val approximation = NormalPoissonApproximation(10000.0)
        assertEquals(0.0, approximation.probabilityMass(20_000 until 30_000), 0.001)
        assertEquals(0.1562, approximation.probabilityMass(0 until 9900), 0.01)
        assertEquals(0.99, approximation.probabilityMass(0 .. 10232), 0.001)
        assertEquals(0.9773, approximation.probabilityMass(0 .. 10200), 0.001)
    }
}