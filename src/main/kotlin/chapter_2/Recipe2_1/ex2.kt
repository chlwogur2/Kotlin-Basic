package chapter_2.Recipe2_1

/**
 * 널 허용 변수 선언
 */

fun main(){

    class Person(val first: String,
                 val middle: String?,   // 널 값을 허용하는 변수 타입
                 val last: String)

    val jkRolling = Person("Joanne", null, "Rolling")
    val northWest = Person("North", null, "West")
}