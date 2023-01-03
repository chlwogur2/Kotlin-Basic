package bj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var sum = 0
    val n = readLine()
    val s = readLine()

    s.forEach {
        sum += Character.getNumericValue(it)
    }
    print(sum)
}