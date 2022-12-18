package deemoKotlin

/**
 * 코틀린에서는 인터페이스 역시
 * 추상함수, 일반함수를 가질 수 있음
 * 대신 추상 클래스와는 다르게 생성자를 가질 수는 없다.
 *
 * 인터페이스에서 구현부가 있는 함수는 open함수로 간주
 * 구현부가 없는 함수는 abstract함수로 간주한다.
 * -> 따라서 별도의 open, abstract 키워드가 없어도 서브클래스에서 구현 및 재정의가 가능하다
 * 또한 한 번에 여러 인터페이스를 상속받을 수 있다
 */

interface Runner {
    fun run()
}

interface Eater {
    fun eat(){
        println("음식을 먹습니다.")
    }
}

class Catt : Runner, Eater {
    override fun run(){
        println("우다다다 달리기")
    }

    override fun eat() {
        println("음식을 마구마구 먹습니다.")
    }
}

