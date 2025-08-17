package incava.week6


fun main() {
    val s = Solution()
}


class Solution {

    fun solution(sizes: Array<IntArray>): Int {
        var maxW = 0
        var maxH = 0
        for (s in sizes) {
            // 가로는 무조건 크게, 세로는 무조건 작게 명함을 배열 한다.
            val w = maxOf(s[0], s[1])
            val h = minOf(s[0], s[1])
            // 이전 값과 비교해서 큰 값을 대입
            maxW = maxOf(maxW, w)
            maxH = maxOf(maxH, h)
        }
        return maxW * maxH
    }
}
