package deemoKotlin

fun main() {
    val nameList = listOf("박수영", "김지수", "김다현", "신유나", "김지우")

    // 1. forEach: 컬렉션 요소 하나하나에 전부 접근, it 으로 참조할 수 있다
    nameList.forEach{   // 루프 매개변수 "it"을 사용해야 함
        print("$it ")
    }

    // 2. filter: 조건을 충족하는 요소만 뽑아 새로운 컬렉션으로 반환, it 으로 참조할 수 있다
    println( nameList.filter {
        it.startsWith("김")
    } )

    // 3. map: 컬렉션 요소 하나하나에 접근하여 새로운 동작을 추가하여 컬렉션으로 반환, it 으로 참조할 수 있다
    println( nameList.map{
        "이름: $it"   // 각각의 이름 앞에 "이름: "을 붙인 리스트를 만듦
    })

    // 4. any: 조건을 만족하는 요소가 있는지 Boolean 반환
    println( nameList.any{
        it == "김지연"
    })

    // 5. all: 모든 요소가 조건을 만족하는지 Boolean 반환
    println( nameList.all{
        it.length == 3
    })

    // 6. none: 모든 요소가 다음 조건을 만족하지 않는지 Boolean 반환
    println( nameList.none{
        it.startsWith("이")
    })

    // 7. first: 조건을 만족하는 첫번째 요소 반환
    println( nameList.first{
        it.startsWith("김")
    })

    // 8. last: 조건을 만족하는 마지막 요소 반환
    println( nameList.last{
        it.startsWith("김")
    })

    // 9. count: 조건을 만족하는 요소 개수 반환
    println( nameList.count{
        it.contains("지")
    })
}