package br.com.sf.sample

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit


@BenchmarkMode(Mode.Throughput)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 0)
@Warmup(iterations = 0)
@Measurement(iterations = 2, time = 2, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class FibonacciBenchmark {

    @Param(
        "15", "16", "17", "18", "19", "20", "21",
        "22", "23", "24", "25", "26", "27", "28",
        "33"
    )
    private var value = 0

    @Benchmark
    fun fib() {
        val tmp = Fibonacci.memorization(value)
//        val tmp = Fibonacci.tail(value)
//        val tmp = Fibonacci.classic(value)
        println(tmp)
    }

}
