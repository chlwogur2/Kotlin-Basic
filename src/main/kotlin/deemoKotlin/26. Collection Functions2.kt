package deemoKotlin

// associateBy: 객체에서 key를 추출하여 map으로 반환
/**
 * 리스트에 [이름,태어난 연도] 쌍 객체가 들어가 있고,
 * 이 리스트를 이름을 key, 태어난 연도를 value로 하는 map으로 변경하려면,
 *      collection.associateBy{it.이름}
 * 중괄호 안에는 key로 사용할 속성
 */

// groupBy: key 가 같은 아이템끼리 배열로 묶어 map 으로 만드는 함수
/**
 *  collection.groupBy{it.birthYear}
 */

// partition: 아이템에 조건을 걸어 두 개의 컬렉션으로 나누어 줌
/**
 *  조건이 true 인지, false 인지에 따라 두 컬렉션으로 나누어 줌
 *  Pair 라는 컬렉션 객체가 생성되어, 나뉜 두 개의 컬렉션을 각각 first, second 로 참조할 수 있음
 *  collection.partition{it.birthYear > 2002}
 */

fun main() {
    data class Person(val name:String, val birthYear: Int)

    val personList = listOf(Person("유나", 1992), Person("조이", 1996),
                            Person("재혁", 1996), Person("지혜", 2000))

    println( personList.associateBy { it.name } )   // 이름을 key 로 하는 map 생성
    println( personList.groupBy { it.birthYear })   // 생년월일이 같은 애들을 배열로 묶어 map 생성

    val (over1998, under1998) = personList.partition { it.birthYear > 1997 }    // 조건을 걸어 (true, false에 따라) 컬렉션 2개 생성
    println(over1998)
    println(under1998)

}
