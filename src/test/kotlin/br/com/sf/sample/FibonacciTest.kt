package br.com.sf.sample

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class FibonacciTest {
    @Test
    fun testFib() {
        assertEquals(144, Fibonacci.memorization(12))
        assertEquals(144, Fibonacci.classic(12))
        assertEquals(144, Fibonacci.tail(12))
    }
}
