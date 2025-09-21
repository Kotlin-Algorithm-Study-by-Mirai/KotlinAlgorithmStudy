package athena.week10

fun main() {
    val solution = Solution()
    println(solution.solution(80, arrayOf(intArrayOf(30, 10), intArrayOf(80, 20), intArrayOf(50, 40))))
}

class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer = 0
        val n = dungeons.size
        val visited = BooleanArray(n)

        fun dfs(hp: Int, count: Int) {
            if (count > answer) answer = count

            for (i in 0 until n) {
                if (visited[i]) continue // 방문했으면 i+1로 넘어가기

                val requestFatigue = dungeons[i][0]
                val cost = dungeons[i][1]

                if (hp >= requestFatigue) {
                    visited[i] = true
                    dfs(hp - cost, count + 1)
                    visited[i] = false
                }
            }
        }
        dfs(k, 0)
        return answer
    }
}

/*
* 1. 최소 필요 필요도: 탐험을 시작하기 위해 필요함, 그 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
* 2. 소모 피로도: 탐험 종료 후, 소모되는 피로도
* 3. 문제
*  - 하루 최대 몇 개까지 많은 탐험이 가능한지 solution 함수를 통해 구하라.
*  - k: 현재 피로도, dungeons: arrayof(최소 필요도, 소모피로도)
*  - ( 80,	[[80,20],[50,40],[30,10]] )
* */