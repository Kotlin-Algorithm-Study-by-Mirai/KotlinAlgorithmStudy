package incava.week4

fun main() {
    val s = Solution()
    val tickets = arrayOf(
        arrayOf("ICN", "JFK"),
        arrayOf("HND", "IAD"),
        arrayOf("JFK", "HND")
    )
    println(s.solution(tickets).toList())
}



class Solution {
    private lateinit var answer: List<String>
    private lateinit var ticketsUsed: BooleanArray


    fun solution(tickets: Array<Array<String>>): Array<String> {
        // 중복되는 경로가 있을 경우, 알파벳이 빠른 순서부터 체크
        // DFS 사용 시, 먼저 읽힌 경로가 우선 탐색되므로 알파벳 순으로 정렬
        tickets.sortWith(compareBy({ it[0] }, { it[1] }))
        ticketsUsed = BooleanArray(tickets.size)
        answer = mutableListOf()
        dfs("ICN", mutableListOf("ICN"), tickets)
        return answer.toTypedArray()
    }



    private fun dfs(current : String,route:MutableList<String>,tickets:Array<Array<String>>){
        // 이미 정답 찾았으면 더 이상 탐색 X
        if (answer.isNotEmpty()) return
        // 현재 루트와 다음 루트가 같다면 리턴
        // 나중에 답보고 안 부분
        // 티켓을 모두 사용하여야 하기때문에 경로와 티켓의 갯수는 1차이가 나야 정답으로 인정해야함.
        if (route.size == tickets.size + 1) {
            answer = route.toList()
            return
        }
        //
        for (i in tickets.indices) {
            if (!ticketsUsed[i] && tickets[i][0] == current) {
                ticketsUsed[i] = true
                route.add(tickets[i][1])
                dfs(tickets[i][1], route, tickets)
                // 백트래킹 사용하여 최소화
                // 여기까지 읽혔다는건 실패했다는 얘기 or 이미 완수 했을 수 있음.
                // 재귀 후 다시 되돌리기
                route.removeAt(route.lastIndex)
                ticketsUsed[i] = false
            }
        }
    }
}