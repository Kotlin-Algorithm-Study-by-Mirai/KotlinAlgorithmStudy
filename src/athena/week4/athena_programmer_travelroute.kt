package athena.week4

fun main() {
    val solution = Solution()
    println(
        solution.solution(arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND")))
            .joinToString { it })
}

class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val visited = BooleanArray(tickets.size)
        var bestPath: Array<String>? = null

        val sortedTickets = tickets.sortedWith(compareBy({ it[0] }, { it[1] }))

        fun dfs(current: String, path: MutableList<String>) {
            if (path.size == tickets.size + 1) {
                val newPath = path.toTypedArray()
                if (bestPath == null || newPath.contentToString() < bestPath!!.contentToString()) {
                    bestPath = newPath
                }
                return
            }

            for (i in sortedTickets.indices) {
                if (!visited[i] && sortedTickets[i][0] == current) {
                    visited[i] = true
                    path.add(sortedTickets[i][1])

                    dfs(sortedTickets[i][1], path)

                    visited[i] = false
                    path.removeLast()
                }
            }
        }
        val startPath = mutableListOf("ICN")
        dfs("ICN", startPath)

        return bestPath!!
    }
}