package deemoKotlin

/**
 * val a : String? = null 처럼
 * Nullable 타입을 사용하여, null을 할당할 수 있는데,
 * null이 할당된 채로 a를 사용하려면 NPE가 발생하기 때문에
 * Nullable 변수를 사용할 때는
 * 항상 if (a != null) 처럼 null 체크를 해줘야 "컴파일"이 된다
 *
 * --> 일일이 if문으로 널 체크를 해야할까? 놉!
 *
 * --> ?. [null safe 연산자]
 * --> 참조 연산자를 실행하기 이전에, 객체가 null 인지부터 확인함. 객체가 null 이라면 뒤따라 오는 구문을 실행 안함
 * --> a?.upperCase
 * ---> scope 함수와 사용하면 더더욱 편리함
 *
 * --> ?: [elvis 연산자]
 * --> 객체가 null이 아니라면 그대로 사용하지만, null 이라면, "연산자 우측"의 객체로 대체되는 연산자
 * --> a?:"default"
 *
 * --> !!. [non-null assertion 연산자]
 * --> 참조 연산자를 사용할 떄, null 여부를 컴파일 시 확인하지 않도록 하여
 * --> 런타임 시, NPE가 나도록 "의도적으로" 방치하는 연산자
 */

fun main() {
    var a: String? = null

    println(a?.uppercase()) // a가 null 이므로 uppercase()가 실행되지 않아 "null" 이 출력

    println(a?:"hello".uppercase()) // a가 null 이므로 대신 "hello" 문자열로 대체되어 "HELLO" 출력

    println(a!!.uppercase())    // NPE 발생

    // 스코프 함수와 같이 사용, 전체가 실행 안됨 -> null 체크를 위한 if문보다 훨씬 편리
    a?.run {
        println(uppercase())
        println(lowercase())
    }

    // 스코프함수 전체가 실행됨
    var b: String? = "deemoKotlin.Hello, World!"
    b?.run {
        println(uppercase())
        println(lowercase())
    }
}
