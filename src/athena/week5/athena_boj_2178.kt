package athena.week5

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arrays = Array(n) { readln().map { it.digitToInt() }.toIntArray() }
    val visited = Array(n) { IntArray(m) }

    //(상, 하, 좌, 우)
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(0 to 0)
    visited[0][0] = 1

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m) continue

            if (arrays[nx][ny] == 1 && visited[nx][ny] == 0) {
                visited[nx][ny] = visited[x][y] + 1
                queue.add(nx to ny)
            }
        }
    }
    println(visited[n - 1][m - 1])
}