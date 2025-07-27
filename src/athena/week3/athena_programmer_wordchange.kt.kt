package athena.week3

fun main() {
    val solution = Solution()
    println(solution.solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log")))
}

class Solution {
    var answer = Int.MAX_VALUE

    fun solution(begin: String, target: String, words: Array<String>): Int {
        if (!words.contains(target)) {
            return 0
        } else {
            val visited = BooleanArray(words.size)
            dfs(begin, target, words, visited, 0)
        }
        return if (answer == Int.MAX_VALUE) 0 else answer
    }

    fun dfs(begin: String, target: String, words: Array<String>, visited: BooleanArray, depth: Int) {
        if (begin == target) {
            answer = minOf(answer, depth)
            return
        }

        for (i in words.indices) {
            if (!visited[i] && checkLetter(begin, words[i])) {
                visited[i] = true
                dfs(words[i], target, words, visited, depth + 1)
                visited[i] = false
            }
        }
    }

    private fun checkLetter(begin: String, word: String): Boolean {
        var count = 0
        for (i in begin.indices) {
            if (begin[i] != word[i]) count++
            if (count > 1) return false
        }
        return count == 1
    }
}

