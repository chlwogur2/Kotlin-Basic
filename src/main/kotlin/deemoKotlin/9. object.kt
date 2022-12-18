package deemoKotlin

/**
 * 생성자 없이 객체를 직접 만들어내는 Object
 *
 * 기존의 class는 인스턴스를 만들어내기 위한 "틀"이기 때문에
 * class의 속성이나 함수를 사용하려면 "생성자"를 통해
 * 실체가 되는 인스턴스를 만들어 내야 했다
 *
 * 그런데 많은 인스턴스가 필요한 것이 아니고,
 * 하나의 인스턴스로 공통적인 속성과 함수를 사용해야 하는 코드에서는
 * Class 말고 Object를 사용하면 된다
 *
 * ---> 즉, 코드 차원에서 Singleton 패턴을 지원하는 것이다
 *
 * Object는 "최초 사용 시 자동으로 생성"되며,
 * 프로그램이 종료될 때까지 공통적으로 사용할 내용들을 묶어 만드는 것이 좋다
 */

fun main(){
    // Object는 인스턴스를 생성하지 않기 때문에, object에 직접 참조 연산자 . 를 붙여 사용한다
    println(Counter.count)

    Counter.countUp()
    Counter.countUp()
    println(Counter.count)

    println(Counter.clear())
    println(Counter.count)
}

// 보다시피 object는 생성자가 없음
// object는 인스턴스를 생성하지 않고, 그 자체로 객체이기 때문임
object Counter {
    var count = 0

    fun countUp() {
        count++
    }

    fun clear() {
        count = 0
    }
}