package athena.week5

import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val picture = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(n) { IntArray(m) }

    //(상, 하, 좌, 우)
    val dx = intArrayOf(0, 0, +1, -1)
    val dy = intArrayOf(+1, -1, 0, 0)

    var count = 0
    var maxArea = 0

    val queue: Queue<Pair<Int, Int>> = LinkedList()

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (picture[i][j] == 1 && visited[i][j] == 0) {
                count++
                var area = 0
                queue.clear()
                queue.add(i to j)
                visited[i][j] = 1

                while (queue.isNotEmpty()) {
                    val (x, y) = queue.poll()
                    area++

                    for (k in 0..<4) {
                        val nx = x + dx[k]
                        val ny = y + dy[k]

                        if (nx !in 0 until n || ny !in 0 until m) continue

                        if (picture[nx][ny] == 1 && visited[nx][ny] == 0) {
                            visited[nx][ny] = 1
                            queue.add(nx to ny)
                        }
                    }
                }
                if (area > maxArea) maxArea = area
            }
        }
    }
    println(count)
    println(maxArea)
}