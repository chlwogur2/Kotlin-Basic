package deemoKotlin

// flatMap: 아이템마다 만들어진 컬렉션을 합쳐서 반환해줌
/**
 * collection.flatMap{
 *      listOf(it*3, it+3)
 * }
 */

// getOrElse: 인덱스 위치에 아이템이 있으면 아이템을 반환하고 아닌 경우 지정한 기본값을 반환하는 함수
/**
 * collection.getOrElse (1) {50}
 */

// zip: 컬렉션 두 개의 아이템을 1:1로 매칭하여 새 컬렉션을 만들어 줌
/**
 * 두 컬렉션 요소를 1:1로 Pair 클래스의 객체로 만들어,
 * 리스트에 담아서 반환
 * 결과 리스트의 아이템의 개수는 더 작은 컬렉션을 따라가게 됨
 *
 * collectionA zip collectionB
 */

fun main() {
    val numbers = listOf(-3, 7, 2, -10, 1)

    println(numbers.flatMap { listOf(it * 10, it + 10) })   // [-30, 7, 70, 17, 20, 12, -100 ...]

    println(numbers.getOrElse(1){50})  // 7
    println(numbers.getOrElse(10){50}) // 50


    val names = listOf("A", "B", "C", "D")
    println(names zip numbers)  // [(A, -3), (B, 7), (C, 2), (D, -10)]


}