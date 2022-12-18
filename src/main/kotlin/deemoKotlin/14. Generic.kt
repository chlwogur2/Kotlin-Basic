package deemoKotlin

/**
 * Generic: 클래스나 함수에서 사용되는 자료형을 외부에서 지정할 수 있는 기능
 *
 * 수퍼클래스 A와 그 A를 상속받는 서브클래스 B 가 있음
 * 이 두 클래스의 인스턴스를 공용으로 파라미터로 받는 하나의 함수가 있다면 어떻게?
 * fun ex(var a:A) 이렇게 수퍼클래스인 A로 받으면, B는 자동 A로 업캐스팅이 됨 --> "하지만 캐스팅 연산은 비용이 비싸다"
 *
 * 따라서 Generic이 등장 -> 실제 자료형으로 대체되는 타입 파라미터를 받아 사용하는 방법
 * ---------------------------------------------------------------------------------
 * // 선언 (함수)
 * fun <T> genericFunc(var param:T){}
 * // 사용 (함수)
 * genericFunc(1) -> 1을 통해 Int형임을 자동으로 추론
 * * ---------------------------------------------------------------------------------
 * // 선언 (클래스)
 * class GenericClass<T>
 * // 사용 (클래스) -> 타입 파라미터 수동 지정
 * GenericClass<Int>()
 * * ---------------------------------------------------------------------------------
 * // 선언 (클래스) -> 생성자에 제네릭이 사용된 경우
 * class GenericClass<T>(var pref:T)
 * // 사용
 * GenericClass(1) -> 지정하지 않아도 자동으로 추론됨
 */

fun main(){
    UsingGeneric(SuperA()).doShouting() // 수동<>으로 타입파라미터를 전달하기 않아도 생성자의 파라미터를 통해 타입을 추론 가능함 -> 안해도 됨
    UsingGeneric(SubB()).doShouting()
    UsingGeneric(SubC()).doShouting()

    genericShout(SubB())
}

// 함수
fun <T: SuperA> genericShout(t : T) {
    t.shout()
}

open class SuperA {
    open fun shout(){
        println("A가 소리칩니다")
    }
}

class SubB : SuperA() {
    override fun shout() {
        println("B가 소리칩니다")
    }
}

class SubC : SuperA() {
    override fun shout() {
        println("C가 소리칩니다")
    }
}

// 수퍼클래스를 SuperA로 제한한 제너릭 T 선언
class UsingGeneric<T: SuperA> (val t: T){   // 생성자에서 T에 맞는 속성을 t로 받음
    fun doShouting(){
        t.shout()
    }
}

/**
 * class deemoKotlin.UsingGeneric(val t: A){...}
 * 처럼 생성자를 이용해서 수퍼클래스와 그 하위클래스를 받을 수 있도록 지정할 수 있지만,
 * 이러면 불필요한 캐스팅을 방지할 수 있어 성능을 더 높일 수 있다
 */