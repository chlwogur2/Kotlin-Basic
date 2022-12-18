package deemoKotlin

/**
 * Data Class
 * -> 데이터를 다루는데 최적화된 클래스
 * -> '5'가지 기능을 내부적으로 자동으로 생성해줌
 *
 * 1. 내용의 동일성을 판단하는 'equals()'의 자동 구현
 * 2. 객체의 내용에서 고유한 코드를 생성하는 'hashcode()'의 자동 구현
 * 3. 포함된 속성을 보기 쉽게 나타내는 'toString()'의 자동 구현
 * 4. 객체를 복사하여 똑같은 내용의 새 객체를 만드는 'copy()'의 자동 구현
 *  -> copy() 함수에 파라미터를 주어 속성의 일부를 교체할 수도 있음
 * 5. 속성을 순서대로 반환하는 componentX() 의 자동 구현 (개발자가 쓰는건 아니고 배열, 리스트에서 값을 꺼내는 기능을 지원할 때)
 *  -> Data("A", 7) 에서,
 *  -> component1() == "A", component2() == 7
 */

fun main() {
    // 일반 클래스로 만든 a는 equals(), hashcode(), toString()의 결과가 제대로 출력되지 않음
    val a = General("보영", 212)
    println(a == General("보영", 212))    // a와 똑같은 객체 비교
    println(a.hashCode())   // a의 해시코드
    println(a)  // toString 결과값 확인용
    println()

    // Data 클래스로 만든 b는 전부 제대로 구현이 잘됨, copy() 함수를 통해 원본을 복사한 새 객체도 쉽게 만들 수 있음
    val b = Data("지혜", 158)
    println(b == Data("지혜", 158))   // b와 똑같은 객체 비교
    println(b.hashCode())
    println(b)
    println(b.copy())
    println(b.copy("재혁"))

    // componentX 함수 동작 확인
    val list = listOf(Data("A",123), Data("B",456), Data("C",789))

    for ((a,b) in list){    // 두 개의 속성을 받을 수 있는 이름 ex) (a,b) 를 사용하면 됨
        println("${a}, ${b}")   // 내부적으로 a = component1(), b = component2()
    }

}

class General(val name: String, val id: Int)

data class Data(val name: String, val id: Int)