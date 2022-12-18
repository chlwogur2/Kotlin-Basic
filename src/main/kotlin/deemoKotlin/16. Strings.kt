package deemoKotlin

fun main() {
    val test = "deemoKotlin.Hello.World.ln"

    println(test.length)
    println(test.uppercase())
    println(test.lowercase())

    val test2 = test.split(".") // 반환형은 List<String>
    println(test2)

    println(test2.joinToString(".")) // 리스트를 다시 문자열로 합침, 인자로 들어가는 것은 리스트 요소 사이사이에 뭘 넣을건지

    println(test.substring(6..10))  // 문자열 자르기 (끝점 포함)

    println(test.startsWith("H"))   // 문자열이 H로 시작하는가? Boolean 리턴
    println(test.endsWith("n")) // 문자열이 n으로 끝나는가? Boolean 리턴
    println(test.contains("llo"))   // 포함?

    // --------------------------------------------

    val str : String? = null    // nullable로 null 값 할당
    val emptyString = ""
    val blankString = " "

    println(emptyString.isNullOrEmpty())    // 문자열이 아예 비어있는가? "" -> true
    println(emptyString.isNullOrBlank())    // 문자열이 공백을 포함하여 비어있는가? true

    println(blankString.isNullOrEmpty())    // false 왜냐면 공백문자가 있으니
    println(blankString.isNullOrBlank())    // true
}