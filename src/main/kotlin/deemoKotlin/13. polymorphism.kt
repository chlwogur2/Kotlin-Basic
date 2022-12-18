package deemoKotlin

/**
 * Up-casting: 상위 자료형인 수퍼클래스로 변환 (콜라 -> 음료)
 * - 그냥 상위 자료형에 하위 자료형을 담으면 된다. (a의 자료형인 Drink에 Cola의 인스턴스를 생성해서 담음)
 * var a:deemoKotlin.Drink = deemoKotlin.Cola()
 *
 * Down-casting: 하위 자료형인 서브클래스로 변환 (음료 -> 콜라)
 * - 다운캐스팅은 별도의 연산자가 필요하다 'as', 'is'
 *
 *  1. 'as'는 변수를 호환되는 자료형으로 변환해주는 캐스팅 연산자
 *  var a:deemoKotlin.Drink = deemoKotlin.Cola()
 *  a as deemoKotlin.Cola       --> 이렇게 코드 내에서 사용할 시, 즉시 자료형을 변경해준다
 *  위와 같이 사용하면, 변수 a는 이후에 Cola로 동작한다
 *  var b = a as deemoKotlin.Cola -> 처럼 변수에 담아서 사용할 수도 있다.
 *
 * 2. 'is'는 변수가 자료형에 호환되는지를 먼저 체크한 후 변환해준다.
 * 조건문에서 사용된다.
 *  if ( a is deemoKotlin.Cola){...}
 */

fun main() {

    var a = Drink() // 수퍼클래스인 deemoKotlin.Drink 의 함수가 호출됨
    a.drink()

    var b: Drink = Cola()   // 서브클래스인 deemoKotlin.Cola 의 함수가 호출됨 (다운캐스팅)
    b.drink()   // b 는 deemoKotlin.Drink 타입의 변수이지만, deemoKotlin.Cola 의 인스턴스를 담았으므로, override한 drink 함수가 실행된다.
    // [중요] 하지만, b는 deemoKotlin.Drink 타입의 변수이므로 override를 하지 않은 deemoKotlin.Cola 자체의 함수인 washDishes를 호출할 수는 없다
    // b.washDishes() -> 컴파일 에러남 -> 따라서 아래와 같이 b가 deemoKotlin.Cola 의 인스턴스인지 검사를 해야함

    
    if (b is Cola) {   // 1. is는 조건문 안에서만 잠시 다운캐스팅이 된다
        b.washDishes()  // 이러면 출력이 됨
    }

    var c = b as Cola // 2. as를 통해 다운캐스팅한 것을 c에 할당할 수 있다
    c.washDishes()  // 반환값은 당연히 washDishes 함수 참조가 가능하다
    b.washDishes() // 그런데 반환값 뿐만 아니라, 이렇게 변수 자체도 다운캐스팅이 되기 때문에 참조가 가능하다
}

open class Drink {
    var name = "음료"

    open fun drink() {
        println("${name}을 마십니다.")
    }
}

class Cola : Drink() {
    var type= "콜라"

    override fun drink() {
        println("${name} 중에 ${type}을 마십니다.")
    }

    fun washDishes() {
        println("${type}으로 설거지를 합니다.")
    }
}