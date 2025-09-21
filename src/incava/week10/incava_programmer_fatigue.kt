package incava.week10

fun main() {
    val solution = Solution()
    println(solution.solution(80, arrayOf(intArrayOf(30, 10), intArrayOf(80, 20), intArrayOf(50, 40))))
}


class Solution {
    private var maxCount = 0

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val visited = BooleanArray(dungeons.size) { false }
        dfs(k, dungeons, visited, 0)
        return maxCount
    }

    private fun dfs(currentFatigue: Int, dungeons: Array<IntArray>, visited: BooleanArray, count: Int) {
        // 현재까지 탐험한 던전 수로 최대값 갱신
        if (count > maxCount) {
            maxCount = count
        }

        for (i in dungeons.indices) {
            // 아직 탐험하지 않았고, 현재 피로도가 최소 필요 피로도 이상이면 탐험 가능
            if (!visited[i] && currentFatigue >= dungeons[i][0]) {
                visited[i] = true
                // 던전 탐험 -> 피로도 줄어듦, 탐험수 +1
                dfs(currentFatigue - dungeons[i][1], dungeons, visited, count + 1)
                visited[i] = false
            }
        }
    }
}