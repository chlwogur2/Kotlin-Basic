package deemoKotlin// default arguments
/**
 * 패러미터를 받아야 하는 함수이지만,
 * 패러미터가 없더라도 "기본값"으로 동작하고 싶으면?
 *
 * --> default arguments
 *
 * 함수 선언에서 인자로 받는 부분에서,
 * parameter : 타입 = 기본값 으로 선언하면, 기본값이 default argument가 되어 입력받지 않았을 떄는
 * 자동으로 기본값을 통해 함수가 실행된다
 */

fun main() {
    delivery("책")
    delivery("물", 10)
    delivery("볼펜", 15, "사무실")

    // named arguments (설명은 밑에)
    delivery("옷", destination = "옷가게")

    // vararg (파라미터 개수 임의로 넣어도 동작)
    sum(12,3,4)

    // infix 함수
    println(4 multiply 6) // 좌측의 4가 infix 함수가 적용되는 객체 자신 this, 우측의 6이 파라미터로 넘어간 x
    println(4.multiply(6)) // 참조연산자 . 를 사용하여 일반적인 클래스의 함수처럼 사용할 수도 있음
}

fun delivery(name: String, count: Int = 1, destination: String = "집") {
    println("${name}, ${count}개를 ${destination}에 배달하였습니다")
}

// named arguments
/**
 * 어 그런데, 이름과 목적지만 내가 적고,
 * 수량은 기본값인 1로 사용하려면 어떻게 해야하지?
 * delievery("이름", ,"목적지") 처럼 가운데를 비우면 컴파일 에러가 발생하는데??
 *
 * -> named arguments
 * --> 패러미터의 순서와 상관 없이, 패러미터의 "이름"을 사용하여,
 * --> 직접 패러미터를 할당하는 기능
 *
 * deemoKotlin.delivery("이름", destination = "목적지") 와 같이 파라미터의 이름을 지정해 준다
 *
 * 이때, 별도의 파라미터 이름이 지정되지 않은 "이름"은, 순서대로 name 에 할당되지만,
 * destination= 을 통해 파라미터를 직접 이름으로 지정한 "목적지"는 [순서를 무시하고] destination 에 할당된다.
 */

// variable number of arguments (vararg)
/**
 * 같은 자료형을 "개수에 상관없이"
 * 파라미터로 받고 싶을 때 사용한다
 *
 * 이때, vararg는 개수가 지정되지 않으므로, 다른 파라미터와 같이 사용할 때는,
 * "가장 마지막"에 위치해야 한다
 *
 * --> fun sample(x: String, y: Boolean, vararg numbers : Int){...} 처럼
 */
fun sum(vararg numbers: Int) {
    var sum = 0

    // vararg 가 붙은 파라미터는, 마치 배열처럼 for 문으로 참조가 가능하다
    for (number in numbers) {
        sum += number
    }
    println(sum)
}

// infix function
/**
 * 마치 연산자처럼 사용이 가능하다
 * 함수를 정의할 때, 앞에 infix 키워드를 붙이고,
 * 함수 이름을 "infix 함수가 적용될 {자료형.이름}"으로 지정한다.
 *
 * 참고로, class 안에서 infix 함수를 선언할 때는,
 * 적용할 클래스가 자기 자신이므로 infix 함수명에 클래스의 이름은 쓰지 않는다.
 * infix fun deemoKotlin.multiply(x: Int): Int = this * x
 */
// Int 값에 사용할 deemoKotlin.multiply() 함수, 파라미터로 역시 Int 값 x 지정, 반환값도 Int
infix fun Int.multiply(x : Int): Int = this * x




