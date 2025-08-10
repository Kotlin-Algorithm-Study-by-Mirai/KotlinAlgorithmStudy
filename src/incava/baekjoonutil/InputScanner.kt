package incava.baekjoonutil

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


/**
 *  백준 Input Scaaner Templete Util
 */

class InputScanner {
    private val br = BufferedReader(InputStreamReader(System.`in`))
    private var st: StringTokenizer? = null

    private fun ensureTokens() {
        while (st == null || !st!!.hasMoreTokens()) {
            val line = br.readLine() ?: return
            if (line.isNotBlank()) {
                st = StringTokenizer(line)
            }
        }
    }

    fun next(): String {
        ensureTokens()
        return st?.nextToken() ?: throw NoSuchElementException("No more input")
    }

    fun nextInt(): Int = next().toInt()
    fun nextLong(): Long = next().toLong()
    fun nextDouble(): Double = next().toDouble()

    fun nextLine(): String {
        st = null
        return br.readLine() ?: ""
    }

    fun intArray(n: Int): IntArray = IntArray(n) { nextInt() }

    fun intArrayLine(): IntArray {
        var line: String? = br.readLine()
        while (line != null && line!!.isBlank()) {
            line = br.readLine()
        }
        if (line == null) return IntArray(0)
        val tok = StringTokenizer(line)
        return IntArray(tok.countTokens()) { tok.nextToken().toInt() }
    }

    fun intMatrix(n: Int, m: Int): Array<IntArray> = Array(n) { IntArray(m) { nextInt() } }

    fun charGrid(n: Int): Array<CharArray> = Array(n) { (br.readLine() ?: "").toCharArray() }

    fun close() = br.close()
}