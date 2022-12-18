package deemoKotlin

/**
 * 내용의 동일성 vs. 객체의 동일성
 *
 * 내용의 동일성 == (2개)
 * -> 얘는, 자동으로 판단되는 것이 아닌,
 * -> 코틀린의 모든 클래스가 내부적으로 상속 받는 'Any' 최상위 클래스의
 * -> 'equals()' 함수가 반환하는 Boolean 값으로 판단한다.
 * --> 따라서, 기본 자료형에는 자료형의 특징에 따라 이미 equals() 함수가 구현되어 있지만,
 * --> 개발자가 커스텀 class를 만들 때에는 { open fun equals(other:Any?):Boolean } 처럼
 * --> equals를 상속받아 동일성을 확인해주는 구문을 별도로 만들어야 한다
 *
 * 객체의 동일성 === (3개)
 */

fun main() {
    var a = Product("콜라", 1000)

    var b = Product("콜라", 1000)

    var c = a

    var d = Product("사이다", 1000)

    println(a == b)     // 내용 (같음)
    println(a === b)    // 객체 (서로 별개)

    println(a == c)     // 내용 (같음)
    println(a === c)    // 객체 (같음)

    println(a == d)     // 내용 (다름)
    println(a === d)    // 객체 (서로 별개)

}

class Product(val name: String, val price: Int){

    override fun equals(other: Any?): Boolean {
        if (other is Product){  // equals 함수의 파라미터로 들어온 함수가 deemoKotlin.Product 라면
            return other.name == name && other.price == price   // 상품의 이름과 가격이 같은지 비교 (내용의 동일성)
        } else {
            return false    // 애초에 Product가 아니면 false 반환
        }
    }
}
