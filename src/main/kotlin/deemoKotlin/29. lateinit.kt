package deemoKotlin

/**
 * 코틀린에서는 변수를 선언할 때
 * 객체를 바로 할당하지 않는 경우 (var a: Int 처럼, 자료형만 지정해두고 객체는 나중에 할당)
 * 기본적으로 컴파일이 되지 않음
 *
 * 하지만, 경우에 따라서는
 * 변수에 객체를 할당하는 것을
 * 선언과 동시에 할 수 없을 때도 있음
 * 이럴 때, lateinit 사용
 *
 * lateinit var a:Int
 * -> 일단 변수만 선언하고, 초기값은 나중에 할당
 *
 * lateinit으로 할당한 var 변수는,
 * 1. 초기값을 할당하기 전까지 변수를 사용할 수 없음 (에러 발생)
 * 2. 기본 자료형에는 사용할 수 없음 (String 에는 사용 가능)
 * 3. lateinit 변수가 초기화되었는지 확인하려면 "::변수명.isInitialized"  로 체크
 */


fun main() {
    val a = LateInitSample()
    println(a.getLateInitText())    // text 속성이 초기화되기 이전이므로 "기본값" 출력됨

    a.text = "새로 할당한 값"
    println(a.getLateInitText())    // text 속성이 초기화됐으므로 "새로 할당한 값" 출력
}

class LateInitSample {
    lateinit var text: String   // 늦은 초기화

    fun getLateInitText(): String {
        return if (::text.isInitialized) text   // 초기화됐는지 check
        else "기본값"
    }
}