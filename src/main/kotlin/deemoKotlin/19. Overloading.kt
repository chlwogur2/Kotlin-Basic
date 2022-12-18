package deemoKotlin

fun main() {
    read(7)
    read("문자열 입니다.")
}

fun read(x: Int) {
    println("숫자 ${x}입니다.")
}

fun read(x: String) {
    println(x)
}
