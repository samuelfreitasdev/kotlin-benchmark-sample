package br.com.sf.sample

object Fibonacci {

    fun memorization(n: Int): Long {
        var a = 1L
        var b = 1L

        for (i in 0..< n - 2) {
            val aux = a + b
            a = b
            b = aux
        }

        return b
    }

    fun classic(n: Int): Long {
        return if (n < 2) {
            n.toLong()
        } else classic(n - 1) + classic(n - 2)
    }

    fun tail(n: Int): Long {
        return tail(n, 0, 1).toLong()
    }

    private fun tail(n: Int, a: Int, b: Int): Int {
        if (n == 0) {
            return a
        }
        return if (n == 1) {
            b
        } else tail(n - 1, b, a + b)
    }
}
