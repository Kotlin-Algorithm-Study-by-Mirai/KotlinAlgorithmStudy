package incava.week5

import incava.baekjoonutil.InputScanner
import kotlin.math.max


fun main() {

    var picture = 0 // 그림 갯수
    var maxAreaLen = 0 // 가장 큰 그림 크기

    val inputScanner = InputScanner()
    val n = inputScanner.nextInt()
    val m = inputScanner.nextInt()
    val board = Array(n) { inputScanner.intArrayLine() }
    val visited = Array(n) { BooleanArray(m) } // 자리 탐색


    // 완전 탐색 필요
    for (i in 0 until n) {
        for (j in 0 until m) {
            if(board[i][j] == 1 && !visited[i][j]) {
                // 그림을 찾음
                picture++
                // bfs한 값과 maxLen 중 가장 높은 값 만 저장하도록 추가
                maxAreaLen = max(maxAreaLen,bfs(i,j,visited,board))
            }
        }
    }
    println(picture)
    println(maxAreaLen)

}


fun bfs(row: Int, col: Int,visited : Array<BooleanArray>, board : Array<IntArray>): Int {
    val q = ArrayDeque<Pair<Int, Int>>()
    val n = visited.size
    val m = visited[0].size
    // 방문 표시
    visited[row][col] = true
    // 큐에 현재 방문 영역 추가
    q.add(row to col)
    var area = 1
    val dr = intArrayOf(1, -1, 0, 0) // 행으로 영역 탐색
    val dc = intArrayOf(0, 0, 1, -1) // 열로 영역 탐색

    while (q.isNotEmpty()) {
        val (r, c) = q.removeFirst()
        for (k in 0 until 4) {
            val nr = r + dr[k]
            val nc = c + dc[k]
            if (nr !in 0 until n || nc !in 0 until m) continue
            if (visited[nr][nc] || board[nr][nc] == 0) continue
            visited[nr][nc] = true
            q.add(nr to nc)
            area++
        }
    }
    return area
}