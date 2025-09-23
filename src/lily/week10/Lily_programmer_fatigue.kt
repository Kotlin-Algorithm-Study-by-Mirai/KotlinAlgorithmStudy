package lily.week10

fun main() {
    val solution = Solution()
    println(solution.solution(100, arrayOf(intArrayOf(40, 50), intArrayOf(50, 30), intArrayOf(50, 30))))
}

class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val dungeonCount = dungeons.size
        var maxExploredCount = 0
        val visitedDungeon = BooleanArray(dungeonCount)

        fun dfs(currentFatigue: Int, exploredCount: Int) {
            maxExploredCount = maxOf(maxExploredCount, exploredCount)

            for (i in dungeons.indices) {
                val requiredFatigue = dungeons[i][0]
                val consumedFatigue = dungeons[i][1]
                if (!visitedDungeon[i] && currentFatigue >= requiredFatigue) {
                    visitedDungeon[i] = true
                    dfs(currentFatigue - consumedFatigue, exploredCount + 1)
                    visitedDungeon[i] = false
                }
            }
        }
        dfs(k, 0)
        return maxExploredCount
    }
}