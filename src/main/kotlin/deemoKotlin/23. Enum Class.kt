package deemoKotlin

// enum은 선언 시에 만든 객체를 이름으로 참조하여 그대로 사용한다
/**
 * 일반적으로 enum 클래스 안의 객체들은 상수를 나타내기 위한 대문자로 기술
 *  enum class Color{
 *      RED, BLUE, GREEN
 *  }
 */

/**
 * enum 클래스 안의 객체들은 고유한 속성을 가질 수 있음
 * enum 클래스의 생성자를 만들어 속성을 받도록 하면,
 * 객체를 선언할 때, 속성도 선언할 수 있다
 *  enum class Color(val number:Int){
 *      RED(1), BLUE(2), GREEN(3)
 *  }
 */

/**
 * 일반 클래스처럼 함수도 추가할 수 있다
 *   enum class Color(val number:Int){
 *      RED(1), BLUE(2), GREEN(3);  // 객체의 선언이 끝나는 위치에 ; 추가하고 함수 작성
 *
 *      fun isRed() = this == Color.RED
 *  }
 */

fun main() {
    var state = State.SING
    println(state)  // 1. enum 변수 그대로 출력하면, toString()을 통해 상태 객체의 "이름"이 출력됨 (SING)
    println(state.message)  // 2. enum 변수의 속성을 출력하면, 속성(messages)에 담긴 "노래를 부릅니다"가 출력됨

    state = State.SLEEP // 변경
    println(state.isSleeping()) // 3. 같은 객체끼리 비교했으니 true
}

enum class State(val message: String){
    SING("노래를 부릅니다"),
    EAT("밥을 먹습니다"),
    SLEEP("잠을 잡니다");    // 각각이 객체(속성)

    fun isSleeping() = this == SLEEP    // 잠을 자는지의 여부를 Boolean 값으로 반환
}