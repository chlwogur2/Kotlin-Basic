package deemoKotlin

/**
 * 옵저버 패턴이란?
 *
 * 함수로 직접 요청하지 않았지만,시스템 또는 루틴에 의해서 발생하는 동작들 -> 이벤트
 * "이벤트가 일어나는 것을 감시"하는 감시자의 역할을 만듦
 *
 * 옵저버 패턴에는 두 가지 클래스가 필요하다
 * 1. 이벤트를 수신하는 클래스 A
 * 2. 이벤트를 발생시켜 이를 알려주는 클래스 B
 *
 * 이벤트를 전달하는 것은, 두 이벤트 사이에 인터페이스(observer)를 만들어
 * 클래스 B가 이 인터페이스를 만들어 공개하고,
 * 클래스 A가 인테페이스를 구현하여 B에 넘겨주면,
 * B는 인터페이스만 알아도 이벤트를 넘겨줄 수 있다
 *
 * 인터페이스를 코틀린에서는 'listener',
 * 이벤트를 넘겨주는 행위를 'callback' 이라고 한다
 */

fun main(){

    EventPrinter().start()  // 4. Main 함수에서는 EventPrinter의 start함수만 실행하면 된다
}

// 3. 이벤트를 수신해서 출력하는 deemoKotlin.EventPrinter (deemoKotlin.EventListener 구현체)
class EventPrinter: EventListener {

    override fun onEvent(count: Int) {
        print("${count}-")
    }
    fun start() {
        val counter = Counter2(this)    // 'this' 로 Counter의 인스턴스에 구현부를 넘겨줌
        counter.count()
    }
}

// 1. deemoKotlin.EventPrinter <-> Counter를 연결시킬 인터페이스인 deemoKotlin.EventListener
interface EventListener {
    // 이벤트가 발생할 때, 숫자를 넘겨주는 추상함수.
    // 리스너를 통해 이벤트를 반환하는 함수들은 관례적으로 on(행위)를 따름
    fun onEvent(count: Int)
}

// 2. 숫자를 카운트하여 5의 배수마다 이벤트를 발생시킬 deemoKotlin.Counter
class Counter2(var listner: EventListener){
    fun count(){
        for (i in 1..100){
            if (i%5 == 0) listner.onEvent(i)    // 1~100 동안 5의 배수가 될때마다 onEvent 호출
        }
    }
}