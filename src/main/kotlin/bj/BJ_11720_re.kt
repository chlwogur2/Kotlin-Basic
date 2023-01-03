package bj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = run {
    BufferedReader(InputStreamReader(System.`in`))
    var sum = 0
    val r = readLine()
    val s = readLine()
    
    // run 은 확장함수이기 때문에 ?. 를 붙여야 한다
    s?.forEach {
        sum += it.toString().toInt()
    }

    println(s)
}