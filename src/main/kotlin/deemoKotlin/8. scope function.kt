package deemoKotlin

/**
 * 스코프 함수(scope function)란,
 * 함수형 언어의 특징을 좀 더 편리하게 사용할 수 있도록
 * 기본 제공하는 함수
 *
 * 클래스에서 생성한 인스턴스를 scope 함수에 전달하면,
 * 인스턴스의 속성이나 함수를 좀 더 깔끔하게 불러 쓸 수 있다
 *
 * 스코프 함수는 인스턴스의 속성이나 함수를
 * scope 내에서 깔끔하게 분리하여 사용할 수 있다는 점 때문에 코드의 가독성을 향상시킨다
 *
 *
 * 스코프 함수에는
 * 1. apply
 * 2. run
 * 3. with
 * 4. also
 * 5. let
 *
 * 5가지가 있다
 */

fun main(){

    /**
     * deemoKotlin.Book 클래스의 속성 이름과 같은 price 변수
     * 이 상태로 출력을 한다면, 할인된 책 가격인 8000이 아니라, 여기서 변수에 할당한 값인 5000이 출력된다.
     * 이는 run 함수가 인스턴스 내의 price 속성보다,
     * run이 속해있는 'main'함수의 price 변수를 -우선시하고 있기 때문-
     * 이는 run 대신 "let"을 사용하면 해결할 수 있다. (apply 역시 같은 경우가 있다면 also로 대체해서 사용 가능)
     */
    var price = 5000

    /**
     * 1. apply: 만약 책 이름 앞에 "[초특가]"를 붙이 discount 함수를 수행하고 싶으면, 기존에는
        아래와 같이 참조 연산자 . 를 사용하여 수행했겠지만,
        a.name = "[초특가]" + a.name
        a.discount()
     */
    // 인스턴스를 생성할 때, apply 함수를 적용하면, 아래와 같이 람다식으로 생성이 가능하다.
    // 그리고 apply 는 인스턴스를 반환하므로 아래와 같이 변수에 바로 담을 수 있다.
    var a = Book("디모의 코틀린", 10000).apply {
        name = "[초특가]$name"
        discount()
    }

    /**
     * 2. run: 이미 만들어진 인스턴스 a에서 사용
     * 아래와 같이 사용하면, apply에서 수정된 책 이름과 할인된 가격이 출력됨
     */
    a.run {
        println("상품명: $name, 가격: ${price}원")
    }

    // let을 사용해서 5000이 아닌 인스턴스의 가격 8000을 출력하기
    a.let { println("상품명: ${it.name}, 가격: ${it.name}") }

}

// 1. apply: 인스턴스를 생성하고 변수에 담기 전에, "초기화 과정"을 수행할 때 많이 쓰임
// apply는 main 함수와 별도의 scope에서 인스턴스의 변수와 함수를 조작함 -> 코드가 깔끔해짐
class Book(var name: String, var price: Int){
    fun discount(){
        price -= 2000
    }
}

// 2. run: apply처럼 run 스코프 안에서 참조 연산자 . 를 사용하지 않아도 됨
// apply와는 다르게, 일반 람다함수처럼, 인스턴스 대신
// 마지막 구문에 결과값을 반환한다는 차이점이 있음
// 따라서 인스턴스가 이미 만들어진 뒤에, 인스턴스의 함수나 속성을 scope 내에서 사용해야 할 때


// 3. with: run이랑 다른 점은, 참조 연산자 대신 인스턴스를 파라미터로 받는다는 것 뿐..
// a.run {...}
// with(a){...}


// 4. also: 처리가 끝나면 인스턴스를 반환 (=apply)

// 5. let: 처리가 끝나면 최종값을 반환 (=run, 람다)

// 하지만, [apply, run]은 참조 연산자 없이 인스턴스의 변수와 함수를 사용할 수 있고,
// [also, let]은 마치 패러미터로 인스턴스를 넘긴 것처럼 "it"을 통해서 인스턴스를 사용할 수 있다

// also,let 이 패러미터로 인스턴스를 넘기는 귀찮은 과정을 거치는 이유는,
// scope 바깥에 똑같은 이름의 변수나 함수가 중복되어 있는 경우에 "혼란을 방지하기 위해서