package athena.week2

import javax.xml.stream.events.StartElement

fun main() {
    println(Solution().solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))))
}

class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        val visited = BooleanArray(n) { false }

        for (start in 0 until n) {
            if (visited[start].not()) {
                answer += 1
                dfs(n, start, visited, computers)
            }
        }
        return answer
    }

    fun dfs(n: Int, start: Int, visited: BooleanArray, computers: Array<IntArray>) {
        visited[start] = true

        for (end in 0 until n) {
            if (computers[start][end] == 1 && visited[end].not()) {
                dfs(n, end, visited, computers)
            }
        }
    }
}


