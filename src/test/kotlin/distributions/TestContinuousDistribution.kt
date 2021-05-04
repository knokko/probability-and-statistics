package distributions

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.exp

class TestContinuousDistribution {

    @Test
    fun testChanceBetween() {
        val dist1 = ContinuousDistribution({ x -> exp(-x)}, 0.0)
        assertEquals(0.3679, dist1.chanceBetween(lowerBound = 1.0), 0.001)
        assertEquals(0.2858, dist1.chanceBetween(1.0, 2.5), 0.001)
        assertEquals(0.9817, dist1.chanceBetween(upperBound = 4.0), 0.001)
        assertEquals(1.0, dist1.chanceBetween(), 0.001)

        val dist2 = ContinuousDistribution({ x -> 0.5 * cos(x)}, -0.5 * PI, 0.5 * PI)
        assertEquals(0.5, dist2.chanceBetween(upperBound = 0.0), 0.001)
        assertEquals(0.7071, dist2.chanceBetween(-0.25 * PI, 0.25 * PI), 0.001)
        assertEquals(0.8536, dist2.chanceBetween(lowerBound = -0.25 * PI), 0.001)
        assertEquals(1.0, dist2.chanceBetween(), 0.001)
    }
}
