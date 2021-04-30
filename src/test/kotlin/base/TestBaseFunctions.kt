package base

import org.junit.Assert.assertEquals
import org.junit.Test

class TestBaseFunctions {

    @Test
    fun testFactorial() {
        assertEquals(1, factorial(0))
        assertEquals(1, factorial(1))
        assertEquals(2, factorial(2))
        assertEquals(6, factorial(3))
        assertEquals(24, factorial(4))
    }

    @Test
    fun testPermutations() {
        assertEquals(1, permutations(10, 0))
        assertEquals(10, permutations(10, 1))
        assertEquals(90, permutations(10, 2))
        assertEquals(720, permutations(10, 3))
    }

    @Test
    fun testChoose() {
        assertEquals(1, choose(10, 0))
        assertEquals(10, choose(10, 1))
        assertEquals(45, choose(10, 2))
        assertEquals(120, choose(10, 3))
    }
}
