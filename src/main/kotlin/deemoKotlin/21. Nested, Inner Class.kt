package deemoKotlin

/**
 * 중첩 클래스
 * --> 하나의 클래스가 다른 클래스와 강하게 연관되어 있다는 의미를 전달하기 위해서 사용
 * --> 형태만 내부에 존재할 뿐, 실질적으로는 서로 내부의 내용을 공유할 수 없음 (별개의 클래스)
 *  class deemoKotlin.Outer {
 *      class Nested {
 *      }
 *  }
 * 일때, deemoKotlin.Outer.Nested() 처럼 사용
 */

/**
 * 내부 클래스
 * --> 혼자서 객체를 만들 수는 없음, 외부 클래스의 객체가 있어야만 생성과 사용이 가능한 클래스
 * --> 내부 클래스에서 외부 클래스의 속성과 함수를 사용이 가능하다
 *  class deemoKotlin.Outer {
 *      inner class Nested {
 *      }
 *  }
 */

fun main() {
    Outer.Nested().introduce()

    val outer = Outer() // Outer의 객체를 만들어 변수에 담음 -> Inner 클래스에서 사용하기 위해
    val inner = outer.Inner()   // Inner 클래스 생성

    inner.introduceInner()
    inner.introduceOuter()

    outer.text = "Changed deemoKotlin.Outer Class"
    inner.introduceOuter()

}

class Outer {
    var text = "deemoKotlin.Outer Class"

    // 중첩 클래스
    class Nested {
        fun introduce() {
            println("Nested Class")
        }
    }

    // 내부 클래스
    inner class Inner {
        var text = "Inner Class"    // 외부 클래스와 같은 이름의 속성

        fun introduceInner() {
            println(text)   // 내부 클래스 속성 사용
        }

        fun introduceOuter() {
            println(this@Outer.text)    // 외부 클래스와 같은 이름의 속성을 구분하기 위해 this@{외부클래스 이름} 로 참조
        }
    }
}