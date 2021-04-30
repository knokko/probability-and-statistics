package attempt1

import org.nield.kotlinstatistics.geometricMean
import org.nield.kotlinstatistics.median
import org.nield.kotlinstatistics.standardDeviation
import org.nield.kotlinstatistics.variance

fun main() {
    val sequence = arrayOf(20, 17, 50, 62, 13, 7, 43, 10)

    println("sum is ${sequence.sum()} and median is ${sequence.median()}")

    println("variance is ${sequence.variance()} and standard deviation is ${sequence.standardDeviation()}")

    println("the geometric mean is ${sequence.geometricMean()}")
}