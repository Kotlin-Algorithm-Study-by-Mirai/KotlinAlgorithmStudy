package incava.week7

fun main() {
    val solution = Solution()
    println(solution.solution(intArrayOf(1, 2, 3, 4, 5)).joinToString(" "))
    println(solution.solution(intArrayOf(1, 3, 2, 4, 2)).joinToString(" "))
}

class Solution {
    fun solution(answers: IntArray): IntArray {
        // 학생 정보 등록
        val students = listOf(
            StudentInfo(1, intArrayOf(1, 2, 3, 4, 5)),
            StudentInfo(2, intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)),
            StudentInfo(3, intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5))
        )

        // %로 순서 확인 후,맞을 경우 score +1
        for ((i, ans) in answers.withIndex()) {
            students.forEach { student ->
                if (student.answer[i % student.answer.size] == ans) {
                    student.score++
                }
            }
        }
        // 모든 번호 중 체크
        val maxScore = students.maxOf { it.score }

        return students
            .filter { it.score == maxScore }
            .map { it.number } // array로 바꾸기 위해 map으로 먼저 선언
            .toIntArray()
    }

    data class StudentInfo(
        val number: Int,       // 학생 번호(1,2,3)
        val answer: IntArray,  // 찍은 패턴 번호
        var score: Int = 0     // 점수
    )

}