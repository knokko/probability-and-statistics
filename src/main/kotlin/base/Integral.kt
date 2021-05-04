package base

inline fun computeIntegral(f: (Double) -> Double, lowerBound: Double? = null, upperBound: Double? = null): Double {
    return if (lowerBound == null) {
        if (upperBound == null) {
            computeUnboundedNegativeIntegral(f) + computeUnboundedPositiveIntegral(f)
        } else {
            computeUnboundedNegativeIntegral(f, upperBound)
        }
    } else {
        if (upperBound == null) {
            computeUnboundedPositiveIntegral(f, lowerBound)
        } else {
            computeBoundedIntegral(f, lowerBound, upperBound)
        }
    }
}

inline fun computeUnboundedPositiveIntegral(f: (Double) -> Double, lowerBound: Double = 0.0): Double {
    return computeBoundedIntegral(f, lowerBound, lowerBound + 10.0, 50_000) +
            computeBoundedIntegral(f, lowerBound + 10.0, lowerBound + 110.0, 50_000) +
            computeBoundedIntegral(f, lowerBound + 110.0, lowerBound + 1000.0, 25_000) +
            computeBoundedIntegral(f, lowerBound + 1000.0, lowerBound + 10_000.0, 15_000) +
            computeBoundedIntegral(f, lowerBound + 10_000.0, lowerBound + 1_000_000.0, 10_000)
}

inline fun computeUnboundedNegativeIntegral(f: (Double) -> Double, upperBound: Double = 0.0): Double {
    return computeBoundedIntegral(f, upperBound - 10.0, upperBound, 50_000) +
            computeBoundedIntegral(f, upperBound - 110.0, upperBound - 10.0, 50_000) +
            computeBoundedIntegral(f, upperBound - 1000.0, upperBound - 110.0, 25_000) +
            computeBoundedIntegral(f, upperBound - 10_000.0, upperBound - 1000.0, 15_000) +
            computeBoundedIntegral(f, upperBound - 1_000_000.0, upperBound - 10_000.0, 10_000)
}

inline fun computeBoundedIntegral(
    f: (Double) -> Double, lowerBound: Double, upperBound: Double, numSteps: Int = 100_000
): Double {
    val difference = upperBound - lowerBound

    var result = 0.0
    for (step in 0 until numSteps) {
        val x = lowerBound + step * difference / numSteps
        result += f(x) * difference / numSteps
    }

    return result
}
