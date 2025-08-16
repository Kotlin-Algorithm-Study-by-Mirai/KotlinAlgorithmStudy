package athena.week6

fun main() {
    val solution = Solution()
    println(
        solution.solution(
            arrayOf(
                intArrayOf(60, 50),
                intArrayOf(30, 70),
                intArrayOf(60, 30),
                intArrayOf(80, 40)
            )
        )
    )
}

class Solution {
    fun solution(sizes: Array<IntArray>): Int {

        var width = 0
        var height = 0
        for (s in sizes) {
            // 1. sizes를 돌면서 가로, 세로를 비교한다.
            // 2. 규칙 만들기: 한 변(가로)는 최대한 길게, 다른 한 변(세로)는 최대한 짧게하여 최소크기를 구한다.
            val w = maxOf(s[0], s[1])
            val h = minOf(s[0], s[1])
            width = maxOf(width, w)
            height = maxOf(height, h)
        }
        return width * height
    }
}
