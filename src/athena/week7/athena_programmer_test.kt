package athena.week7

fun main() {
    val solution = Solution()
    println(solution.solution(intArrayOf(1, 3, 2, 4, 2)).joinToString(" "))
}

class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf(0, 0, 0)

        var student1 = intArrayOf(1, 2, 3, 4, 5)
        var student2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        var student3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        for ((i, ans) in answers.withIndex()) {
            if (student1[i % student1.size] == ans) answer[0]++
            if (student2[i % student2.size] == ans) answer[1]++
            if (student3[i % student3.size] == ans) answer[2]++
        }

        val maxScore = answer.maxOrNull() ?: 0
        return (1..3).filter { answer[it - 1] == maxScore }.toIntArray()
    }
}