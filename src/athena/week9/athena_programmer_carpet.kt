package athena.week9

import javax.sound.sampled.SourceDataLine

fun main() {
    val solution = Solution()
    println(solution.solution(10, 2))
}

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf(3, 3)
        var total = brown + yellow
        var height = 3
        for (w in 3..total) {
            height = total / w
            if ((w - 2) * (height - 2) == yellow) {
                answer[0] = w
                answer[1] = height
            }
        }
        return answer
    }
}