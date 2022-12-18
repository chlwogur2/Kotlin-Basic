package deemoKotlin

/**
 * List<out T> vs. MutableList<T>
 *
 * 1. List
 * 생성시에 삽입한 객체를 대체, 추가, 삭제가 불가능함
 * listOf(1,2,3)
 *
 * 2. MutableList
 * 객체를 대체, 추가, 삭제가 가능
 * mutableListOf("A","b","C")
 * deemoKotlin.add, remove, removeAt, shuffle (무작위 섞기), sort
 */

fun main() {
    val a = listOf("사과","딸기","배")
    println(a[0])

    for (fruit in a) print("$fruit ")

    println()

    var b = mutableListOf(6,3,1)
    println(b)
    b.add(4)
    println(b)
}