package deemoKotlin

// === 1. 클래스 생성, init, 보조 생성자===
class Person(val name:String, var birthYear: Int){
    fun introduce(){
        println("안녕하세요, 저는 ${name}입니다. ${birthYear}년에 태어났습니다.")
    }

    init {  // 생성자를 통해 "인스턴스 생성 시" 실행되는 함수
        println("${this.name}, ${this.birthYear} 의 deemoKotlin.Person 클래스가 생성되었습니다.")
    }

    /**
     * 보조 생성자
     * 기본 생성자와 다른 형태의 생성자
     * 괄호 안에 필요한 파라미터, 그리고 기본 생성자를 통해 속성을 "초기화" 해줘야 함
     * 보조 생성자가 기본 생성자를 사용하려면
     * 보조 생성자 : this(기본생성자가 필요로 하는 파라미터)
     */
    constructor(name: String) : this(name, 1996){   // 이러면 deemoKotlin.Person 만들 때 연도 없이 이름만 넣어주면 됨
        println("보조 생성자가 사용되었습니다.")
    }
}

fun useClass(){
    var a = Person("박지혜", 2000)
    var b = Person("최재혁", 1996)

    println("안녕하세요, 저는 ${a.name}입니다. ${a.birthYear}년에 태어났습니다.")
    b.introduce()
}
// =============

// === 2. 클래스의 상속===

// 1. 서브 클래스는 수퍼 클래스에 존재하는 속성과 '같은 이름의 속성'을 가질 수 없다.
// 2. 서브 클래스가 생성될 때는 반드시 '수퍼 클래스의 생성자까지 호출'되어야 한다.

/**
 * 클래스가 상속을 받을 수 있게끔 하려면 "open" 키워드를 붙여줘야 한다.
 */
open class Animal(var name:String, var age:Int, var type:String ){
    fun introduce(){
        println("저는 ${type} ${name}이고, ${age}살입니다.")
    }
}

/**
 * 서브 클래스는 수퍼 클래스와 같은 이름의 속성을 가질 수 없으므로,
 * var, val 등을 붙여서 자체 속성으로 만드는 것이 아닌    (var, val를 붙이면 속성으로 선언됨)
 * 일반 파라미터로 받아 deemoKotlin.Animal 클래스의 생성자에 직접 넘겨주도록 하자
 */
class Cat(name: String, age:Int) : Animal(name, age, "고양이"){  // [상속받는 법]= 서브클래스 : 수퍼클래스의 생성자
    fun bark(){
        println("야~~~옹")
    }
}

fun extend(){
    var a = Animal("두부", 5, "고양이")  // 수퍼클래스로 생성한 a와
    var b = Cat("두부", 5)    // 서브클래스로 생성한 b는 같다

    a.introduce()
    b.introduce()
    b.bark()
}
// ==========

// === 3. 오버라이딩 ===
/**
 * 수퍼클래스의 함수에 open 키워드를 붙여주고,
 * 서브클래스의 함수에 override 키워드를 붙여주면 된다.
 */
open class Hello(){
    open fun sayHello(){
        println("안녕")
    }
}

class SubHello() : Hello(){
    override fun sayHello() {
        println("잘가")
    }
}
// ==========

// === 4. 추상 클래스 ===

/**
 * 일부 함수가 구현되지 않은 미완성 클래스이기 때문에,
 * 단독으로 인스턴스를 만들 수 없다.
 */
abstract class Kello(){
    abstract fun sayKello()    // 추상함수

    fun byeKello(){
        println("바이~~")
    }
}

// 상속받아서 구현
class Kellomin() : Kello(){
    override fun sayKello() {
        TODO("Not yet implemented")
    }

}