package incava.week1

import kotlin.math.abs

fun main(){
    val result = Solution().solution(intArrayOf(1, 1, 1, 1, 1),3)
    println(result)
}


class Solution {
    var answer = 0


    fun solution(numbers: IntArray, target: Int): Int {
        dfs(numbers, target,0,0)
        return answer
    }

    fun dfs(numbers: IntArray, target: Int, depth: Int, sum: Int) {

        if (depth == numbers.size) {
            // 마지막 깊이까지 도달 후

            //  ++ 백 트래킹 첨가
            // 남은 숫자 합
            val remainSum = numbers.drop(depth).sum()

            // 도달 불가능한 경우
            if (abs(target - sum) > remainSum) return
            when{
                // 답이 target과 같을 경우 +1
                // 아닐 경우, 리턴
                target == sum -> answer += 1
                else -> return
            }
        }else{
            // 아직 종착지에 오지 않았다면?
            // 노드 값을 더하고
            dfs(numbers, target, depth + 1, sum+numbers[depth])
            // 노드 값을 뺀다
            dfs(numbers, target, depth + 1, sum-numbers[depth])
        }
    }

}