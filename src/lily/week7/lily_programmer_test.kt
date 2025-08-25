package lily.week7

fun main() {
    val solution = Solution()
    println(solution.solution(intArrayOf(1,3,2,4,2)).contentToString())
}

class Solution {
    fun solution(answers: IntArray): IntArray {
        val student1 = intArrayOf(1, 2, 3, 4, 5)
        val student2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val student3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        var student1AnswerCount = 0
        var student2AnswerCount = 0
        var student3AnswerCount = 0

        for (i in answers.indices) {
            if (answers[i] == student1[i % student1.size]) student1AnswerCount++
            if (answers[i] == student2[i % student2.size]) student2AnswerCount++
            if (answers[i] == student3[i % student3.size]) student3AnswerCount++
        }

        val max = maxOf(student1AnswerCount, student2AnswerCount, student3AnswerCount)
        val result = mutableListOf<Int>()
        if (student1AnswerCount == max) result.add(1)
        if (student2AnswerCount == max) result.add(2)
        if (student3AnswerCount == max) result.add(3)

        return  result.toIntArray()
    }
}

