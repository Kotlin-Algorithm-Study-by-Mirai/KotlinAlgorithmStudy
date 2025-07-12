package athena.week1

fun main() {
    print(Solution().solution(intArrayOf(1, 1, 1, 1, 1), 3))
}

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        fun dfs(index: Int, currentSum: Int) {
            if (index == numbers.size) {
                if (currentSum == target) {
                    answer++
                }
                return
            }
            dfs(index + 1, currentSum + numbers[index])
            dfs(index + 1, currentSum - numbers[index])
        }
        dfs(0, 0)
        return answer
    }
}