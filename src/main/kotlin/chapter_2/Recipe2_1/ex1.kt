package chapter_2.Recipe2_1

/**
 * 널 할당이 불가능한 변수 선언
 */
fun main(){

    var name: String    // 1. 변수 타입에 뒤따라오는 물음표 없이 변수 선언
    name = "jaehyuk"    // 2. 널이 아닌 문자열 할당
    // name = null      // 3. 이 친구 주석 지우면 "컴파일 에러" 발생
}