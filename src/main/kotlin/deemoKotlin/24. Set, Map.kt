package deemoKotlin

fun main() {
    // Set
    val a = mutableSetOf("바나나", "사과", "키위")

    for (item in a){
        println("${item}")
    }
    a.add("자몽") // set 추가: add
    println(a)
    a.remove("바나나") // set 삭제: remove
    println(a.contains("자몽"))   // set 포함여부: contains

    // Map
    val b = mutableMapOf("송파" to "서울", "통영" to "경남", "광주" to "전남")  // 키-value를 "to"로 이어줌
    for (entry in b){
        println("${entry.key} : ${entry.value}")    // .key, .value 로 접근 가능
    }

    b["강남"] = "서울"  // 삽입 시, 얘도 되고
    b.put("대구", "경상")    // 얘도 가능

    println(b["대구"])    // key로 value 참조

}