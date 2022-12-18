package deemoKotlin

// 1. 람다함수 역시 여러 줄로 표현이 가능하다
val c = {
    str:String ->
    println("$str 람다 함수")
    println("여러 구문을 ")
    println("사용 가능합니다")
}

// 2. 람다 함수가 여러 줄인 경우, 마지막 구문의 결과값을 반환받는다
val calculate = {
    a:Int, b:Int ->
    println(a+b)
    a+b // 얘가 Int형으로 자동으로 리턴값이 된다
}

// 위의 식은 아래와 똑같다
val calculate2: (Int, Int) -> Int = {
    a, b ->
    println(a+b)
    a+b
}

// 3. 파라미터가 없는 람다함수의 경우, 실행할 구문들만 나열하면 된다
val noParameter: () -> Unit = {
    println("파라미터가 없는뎁쇼")
}

// 4. 람다함수에서 파라미터가 1개라면 "it" 을 사용할 수 있다.
val oneParameter: (String) -> Unit = {
    println("$it it 사용했지롱")
}