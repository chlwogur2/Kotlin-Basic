package deemoKotlin

/**
 * 고차 함수에서, 파라미터로 들어갈 함수를 굳이 이름까지 붙여가며 만들 필요가 있을까??
 * -> 함수를 람다식으로 표현하는 람다함수를 사용한다.
 *
 * 람다 함수는 일반 함수와 달리,
 * 그 자체가 고차 함수이기 때문에
 * 별도의 연산자 없이도 변수에 담을 수 있다.
 * val deemoKotlin.getC : (String) -> Unit
 *
 * 일반적인 변수의 : 뒤에 자료형을 쓰듯,
 * 함수의 형식을 쓰면 되는 것이다.
 */

fun main(){
    // str은 패러미터로 들어온 문자열을 매칭해줄 변수 이름, str:String으로 작성하지 않아도 추론이 가능하기에 타입을 생략할 수 있다.
    val c: (String) -> Unit = { str -> println("$str 람다함수") }

    // 위의 식을 함수의 형식을 적지 않고, 바로 중괄호 안에 "패러미터의 자료형" (str:String) 만 쓰면, 아래와 같이 훨씬 축약할 수 있다.
    val e = {str:String -> println("$str 축약 람다 함수") }

    d(c)    // 람다함수는 그 자체로 고차함수이기에 별도의 :: 연산자가 필요 없다다
}

fun d(function: (String) -> Unit){
    function("d가 호출한")
}



