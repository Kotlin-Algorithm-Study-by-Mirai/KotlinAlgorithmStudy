package incava.week9

fun main() {
    val solution = Solution()
    println(solution.solution(10,2).toList())
}

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        val total = brown + yellow
        // 세로 -2 가로 =2 여야 함 -> yellow
        // (x-2) * (y-2) = yellow
        for (w in total downTo 3) {
            if (total % w != 0) continue
            val h = total / w
            if (w >= h && (w - 2) * (h - 2) == yellow) {
                answer  = intArrayOf(w, h)
                break
            }
        }
        return answer
    }
}