package deemoKotlin

// 상황에 따라 변수를 사용하는 방법을 세세하게 지정이 가능하다
/**
 * 변수를 사용하는 시점까지
 * 초기화를 자동으로 늦춰주는
 * lazy delegate    (지연 대리자 속성)
 *
 * "lateinit" 과 달리
 * val a:Int "by lazy {7}" 처럼
 * "by" 키워드를 사용하여, lazy 라는 람다 함수 형태를 사용
 *
 * 코드에서는 선언 시,
 * 즉시 객체를 생성 및 할당하여
 * 변수를 초기화하는 형태를 갖고 있지만,
 *
 * 실제 실행 시에는
 * "val 변수를 사용하는 시점" 에 초기화됨
 * 따라서 코드의 실행 시간을 최적화할 수 있음
 *
val a: Int by lazy {7}
...
println(a) -> 이 시점에 초기화됨
 *
 * 참고로 람다함수로 초기화가 진행되므로 함수 안에 여러 개의 구문이 들어갈 수 있음
val a: Int by lazy {
println("initializing")
7   -> 이렇게 해도 값은 7이 됨
}
 *
 */

fun main() {

    val number : Int by lazy {
        println("초기화를 합니다") // 초기화 되는 시점 체크
        7   // 얘로 초기화
    }

    println("코드를 시작합니다")
    println(number) // 이 때 초기화가 됨
    println(number) // 이미 초기화를 했기 때문에 다시 초기화 구문을 실행하지는 않음
}