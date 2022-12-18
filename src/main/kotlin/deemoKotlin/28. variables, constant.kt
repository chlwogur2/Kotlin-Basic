package deemoKotlin

/**
 * 1. val 사용 시 주의할 점:
"val"은 할당된 객체를 바꿀 수 없을 뿐이지
객체 내부의 속성을 변경할 수 없는 것은 아니다

 * 2. "상수" -> 절대 변경이 불가능한 것
컴파일 시점에 결정되어 절대 바꿀 수 없는 값
상수로 선언될 수 있는 값은 기본 자료형들과, String 만 가능하다
런타임에 생성될 수 있는 일반적인 다른 클래스의 객체들은 담을 수 없다

클래스의 속성이나, 지역 변수로는 사용될 수 없다
반드시 "companion object" 안에 선언하여, 객체의 생성과 관계 없이
클래스와 관계된 고정적인 값으로만 사용하게 됨
상수의 이름은 관행적으로 대문자와 언더스코어(_) 를 붙인다

const val CONST_A = 1234
 */

// 굳이 변수를 사용하지 않고, 상수를 별도로 사용할까?
// 변수를 사용하는 경우, 런타임 시 객체를 생성하는데 시간이 더 소요되어 "성능의 하락이 있음"
// 따라서, 늘 고정적으로 사용할 값은 상수를 통해 객체의 생성 없이
// 메모리에 값을 고정하여 사용함으로서 성능을 향상시킬 수 있다
fun main() {
    val foodCourt = FoodCourt()

    foodCourt.searchPrice(FoodCourt.FOOD_CREAM_PASTA)
    foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
    foodCourt.searchPrice(FoodCourt.FOOD_PIZZA)
}

class FoodCourt{
    fun searchPrice(foodName: String) {
        val price = when(foodName){
            FOOD_CREAM_PASTA -> 13000
            FOOD_STEAK -> 25000
            FOOD_PIZZA -> 19000
            else -> 0
        }

        println("${foodName}의 가격은 ${price}원입니다.")
    }

    // 이렇게 companion object 에 담아서 상수를 선언
    companion object {
        const val FOOD_CREAM_PASTA = "크림파스타"
        const val FOOD_STEAK = "스테이크"
        const val FOOD_PIZZA = "피자"
    }
}