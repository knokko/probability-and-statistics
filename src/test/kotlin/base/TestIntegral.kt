package base

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.cos

class TestIntegral {

    @Test
    fun testBoundedIntegral() {
        val f1 = { x: Double -> exp(-x) }
        assertEquals(0.2858, computeBoundedIntegral(f1, 1.0, 2.5), 0.001)
        assertEquals(0.9817, computeBoundedIntegral(f1, 0.0, 4.0), 0.001)

        val f2 = { x: Double -> 0.5 * cos(x) }
        assertEquals(0.7071, computeBoundedIntegral(f2, -0.25 * PI, 0.25 * PI), 0.001)
    }

    @Test
    fun testUnboundedPositiveIntegral() {
        val f1 = { x: Double -> exp(-x) }
        assertEquals(0.3679, computeUnboundedPositiveIntegral(f1, 1.0), 0.001)
    }

    @Test
    fun testUnboundedNegativeIntegral() {
        val f1 = { x: Double -> -exp(x) }
        assertEquals(-0.3679, computeUnboundedNegativeIntegral(f1, -1.0), 0.001)
    }

    @Test
    fun testComputeIntegral() {
        val f1 = { x: Double -> exp(-x) }
        assertEquals(0.3679, computeIntegral(f1, 1.0, null), 0.001)
        assertEquals(0.2858, computeIntegral(f1, 1.0, 2.5), 0.001)
        assertEquals(0.9817, computeIntegral(f1, 0.0, 4.0), 0.001)
        assertEquals(0.1, computeIntegral(f1, 2.3026, null), 0.001)
        assertEquals(0.1, computeIntegral(f1, 0.0, 0.1054), 0.001)

        val f2 = { x: Double -> 0.5 * cos(x) }
        assertEquals(0.5, computeIntegral(f2, -0.5 * PI, 0.0), 0.001)
        assertEquals(0.1464, computeIntegral(f2, -0.5 * PI, -0.25 * PI), 0.001)

        val f3 = { x: Double -> x / 8.0 }
        assertEquals(0.5625, computeIntegral(f3, 4.0, 5.0), 0.001)
    }
}
