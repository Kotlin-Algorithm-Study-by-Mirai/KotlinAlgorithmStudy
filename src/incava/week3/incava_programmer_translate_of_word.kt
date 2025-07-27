package incava.week3

fun main() {
    val s = Solution()
    println(s.solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"))) // → 4
    println(s.solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log")))
}



class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        // 1. 만약 target이 array안에 없을 경우, 리턴 0
        if (target !in words) return 0
        // 방문 화인 Array
        val visited = BooleanArray(words.size)
        // Queue를 통해 단어와 횟수를 같이 저장.
        val queue = ArrayDeque<Pair<String, Int>>() // (현재 단어, 변환 횟수)
        queue.add(Pair(begin, 0))
        while (queue.isNotEmpty()) {
            val (currentWord, step) = queue.removeFirst()
            // 만약 타겟과 같을 경우 리턴
            if (currentWord == target) return step
            for (i in words.indices) {
                // 다를 경우, 각 단어를 한글자만 다른 것이 있는지 체크
                if (!visited[i] && checkDiffOneWord(currentWord, words[i])) {
                    visited[i] = true
                    queue.add(Pair(words[i], step + 1))
                }
            }
        }

        return 0 // 변환 불가능한 경우
    }

    // 한 글자만 다른지 체크하는 함수
    private fun checkDiffOneWord(word: String, compareWord: String): Boolean {
        var diffCount = 0
        for (i in word.indices) {
            if (word[i] != compareWord[i]) diffCount++
            if (diffCount > 1) return false
        }
        return diffCount == 1
    }
}