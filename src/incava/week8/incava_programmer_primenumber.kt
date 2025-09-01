package incava.week8

fun main() {
    val solution = Solution()
    println(solution.solution("011"))
}

class Solution {
    fun solution(numbers: String): Int {
        var answer = 0
        val visited = BooleanArray(numbers.length)  // 방문 기록
        val numberSetList = mutableSetOf<Int>()

        fun dfs(cur: Int, depth: Int) {
            if (depth > 0) numberSetList.add(cur) // 모두 다 채운 경우가 아니면 저장
            for (i in numbers.indices) { // 숫자를 하나씩 나누면서
                if (visited[i]) continue
                visited[i] = true
                val digit = numbers[i].digitToInt() // i값에서 숫자 추출
                //println(digit)
                dfs(cur * 10 + digit, depth + 1)
                visited[i] = false
            }
        }

        // numberSetList를 채우기 위해 DFS 사용
        dfs(0, 0)
        //println(numberSetList)

        // prime 체크
        for (num in numberSetList) {
            if (isPrime(num)) answer++
        }

        return answer
    }


    private fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        var i = 2
        while (i * i <= n) { // sqrt 까지만 실행
            if (n % i == 0) return false
            i++
        }
        return true
    }

}