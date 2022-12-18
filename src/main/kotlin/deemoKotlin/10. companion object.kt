package deemoKotlin

/**
 * 기존 class 내부에서도 Object를 만드는 방법 -> Companion object
 *
 * class 에서 인스턴스 만드는 기능은 그대로 사용하면서,
 * 각각의 인스턴스 간에 공용으로 사용할 속성과 함수를 별도로 만드는 기능
 *
 * ---> 즉, 기존의 언어에서 static 멤버와 비슷하다 */

fun main(){
    var a = FoodPoll("짜장")
    var b = FoodPoll("짬뽕")

    a.vote()
    a.vote()

    b.vote()
    b.vote()
    b.vote()

    println("${a.name} : ${a.count}")
    println("${b.name} : ${b.count}")
    println("총계: ${FoodPoll.total}")    // companion object -> 서로 다른 인스턴스임에도, 공유가 되고 있음
}

// 짜장, 짬뽕 투표하는데, 각각의 선호도는 각각 집계하고
// 총 투표수는 total 이라는 companion object로 관리한다
class FoodPoll (val name:String){
    companion object {
        var total = 0
    }

    var count = 0

    fun vote() {
        total++
        count++
    }
}