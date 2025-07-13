package incava.week2

fun main() {
    print(
        Solution().solution(
            3, arrayOf(
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 0, 1)
            )
        )
    )
}


class Solution {

    fun solution(n: Int, computers: Array<IntArray>): Int {
        val visited = BooleanArray(n)
        var count = 0
        computers.forEachIndexed { i, _ ->
            // 깊이 만큼 반복
            if (!visited[i]) {
                // 네트워크가 연결되었는지 체크 후, DFS 체크
                dfs(i, computers, visited)
                count++
            }
        }

        return count
    }

    fun dfs(current: Int, computers: Array<IntArray>, visited: BooleanArray) {
        visited[current] = true // 방문 체크
        computers[current].forEachIndexed { i, isConnected ->
            if (isConnected == 1 && !visited[i]) {
                // 노드끼리 만났고, 방문하지 않았으면 추가로 해당 깊이 생성
                dfs(i, computers, visited)
            }
        }
    }
}