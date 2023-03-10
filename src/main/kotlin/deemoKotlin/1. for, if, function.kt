package deemoKotlin

fun main(){
    var arr= arrayOf(1,2,3,4,5)
    var nullArr = arrayOfNulls<Int>(5)

}

fun add(a: Int, b: Int, c: Int): Int {
    return a + b + c
}


// =========================================================================================
// 이것을 함수라고 생각하지 말고, 외부에서 볼 때는 단순히 값을 전달하면 반환값을 리턴하는 변수라고 생각
fun addSingleExpressionFunction(a:Int, b:Int, c:Int) = a+b+c
// =========================================================================================

// =========================================================================================
// 다른 언어의 switch문과 비슷한 when 문
fun doWhen(a: Any){
    when(a) {
        1 -> println("정수 1입니다.")
        is Long -> println("Long 타입 입니다.")
        !is String -> println("String 타입이 아닙니다.")
        else -> println("어떠한 조건도 만족하지 않습니다.")
    }
}
// =========================================================================================


// =============================[반복문, label 사용법]======================================
// for 문 사용법 좀 다름
fun doFor(){
    // step은 증가하는 단계를 1이 아닌 다른 값으로 하도록
    for(i in 0..9 step 3) print(i)

    // 감소할 때는 9..0 처럼 쓰면 안됨
    for(i in 9 downTo 0) print(i)

    // char(문자) 자료형에도 반복문 가능
    for(i in 'a'.. 'e') print(i)

    /**
     * 다중 반복문에서, break, continue 와 같은 흐름제어 문을 내부에서 사용하면
     * 고전적인 언어에서는 내부 반복문, 외부 반복문 모두에서 break, continue를 해줘야 했지만,
     * 코틀린은 label을 어노테이션으로 달아서, 레이블을 기준으로 흐름제어가 가능하다.
     */
    loop@for (i in 0 .. 9) {    // {레이블이름}@
        for (j in 3 .. 9) {
            if (i == 1 && j == 2) {
                println("i= $i, j= $j") // print문 안에서 변수 출력하는 방법 ($)
                break@loop
            }
        }
    }
}
// =========================================================================================