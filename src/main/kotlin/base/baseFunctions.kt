package base

fun factorial(n: Long): Long {
    if (n < 0) throw IllegalArgumentException("n ($n) is negative")

    var result = 1L
    for (factor in 2 .. n) {
        result *= factor
        if (result < 0) throw IllegalArgumentException("$n! would overflow")
    }

    return result
}

fun permutations(numCandidates: Long, numWinners: Long): Long {
    if (numWinners < 0)
        throw IllegalArgumentException("numWinners ($numWinners) can't be negative")

    if (numCandidates < numWinners)
        throw IllegalArgumentException("numCandidates ($numCandidates) should be at least numWinners ($numWinners)")

    var result = 1L
    for (counter in 0 until numWinners) {
        result *= numCandidates - counter
        if (result < 0) throw IllegalArgumentException("$numCandidates perm $numWinners would overflow")
    }

    return result
}

fun choose(numCandidates: Long, numWinners: Long): Long {
    return permutations(numCandidates, numWinners) / factorial(numWinners)
}
