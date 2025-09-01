package athena.week8

import kotlin.math.sqrt

fun main() {
    val solution = Solution()
    println(solution.solution("011"))
}

class Solution {
    fun solution(numbers: String): Int {
        var answer = generateNumbers(numbers.trim())

        val sorted = answer.toList().sorted()
        val primes = sorted.filter { isPrime(it) }

        println("candidates (${sorted.size}) = $sorted")
        println("primes     (${primes.size}) = $primes")

        return answer.count { isPrime(it) }
    }

    fun generateNumbers(numbers: String): Set<Int> {
        val result = mutableSetOf<Int>()
        val n = numbers.length

        fun permute(prefix: String, remaining: String) {
            if (prefix.isNotEmpty()) {
                result.add(prefix.toInt())
            }
            for (i in remaining.indices) {
                permute(prefix + remaining[i], remaining.removeRange(i, i + 1))
            }
        }
        permute("", numbers)
        return result
    }

    private fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        if (n == 2) return true
        if (n % 2 == 0) return false

        val limit = sqrt(n.toDouble()).toInt()
        var d = 3

        while (d <= limit) {
            if (n % d == 0) return false
            d += 2
        }
        return true
    }
}