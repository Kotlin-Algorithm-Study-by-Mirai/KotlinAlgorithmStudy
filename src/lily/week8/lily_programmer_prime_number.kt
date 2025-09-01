package lily.week8

fun main() {
    val solution = Solution()
    solution.solution("17")
}

class Solution {
    fun solution(numbers: String): Int {
        val numberList = numbers.map { it.toString().toInt() }
        val madeNumbers = mutableSetOf<Int>()

        fun makeNumbers(current: String, remain: List<Int>) {
            if (current.isNotEmpty()) {
                madeNumbers.add(current.toInt())
            }
            for (i in remain.indices) {
                makeNumbers(
                    current + remain[i],
                    remain.toMutableList().apply { removeAt(i) }
                )
            }
        }

        makeNumbers("", numberList)
        return madeNumbers.count { isPrime(it) }
    }

    private fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        val end = kotlin.math.sqrt(n.toDouble()).toInt()
        for (i in 2..end) if (n % i == 0) return false
        return true
    }
}