package deemoKotlin

/**
 * 옵저버 패턴에서
 * 이벤트 프린터가, deemoKotlin.EventListener 를 상속받아서 구현하지 않고,
 * 임시로 만든 별도의 deemoKotlin.EventListener 객체를 대신 넘겨줄 수도 있음
 *
 * --> 익명 객체
 */

fun main() {
    EventPrinter2().start()
}


// 이번엔 EventListener를 상속받지 않은 deemoKotlin.EventPrinter
class EventPrinter2 {
    fun start() {
        val counter = CounterC(object :
            EventListener2 {  // 따로 EventListener를 만들지 않고, 익명함수 (object)를 만들어서 넘김. object와 형태는 비슷하지만 이름이 없음
            override fun onEvent(count: Int) {  // -> 인터페이스를 구현한 객체를 코드 중간에도 즉시 생성하여 사용이 가능
                print("${count}-")
            }
        })
        counter.count()
    }
}

interface EventListener2 {
    fun onEvent(count: Int)
}

class CounterC(var listener: EventListener2){

    fun count() {
        for (i in 1..100) {
            if (i % 5 == 0) listener.onEvent(i)
        }
    }
}
