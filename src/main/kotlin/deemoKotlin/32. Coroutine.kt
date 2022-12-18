package deemoKotlin
import kotlinx.coroutines.*
/**
 * "비동기"로 여러 개의 루틴을 "동시"에 실행하는 코루틴
 * 코루틴은 main 이 되는 루틴과 별도로 진행이 가능하다
 *
 *
*/

/**
 * 코루틴은 제어범위, 실행범위를 지정할 수 있음
 * 이를 "Scope" 라고 함
 *
 * Global Scope, Coroutine Scope 가 있음
1. Global Scope
 * 프로그램 어디서나 제어, 동작이 가능한 기본 범위
2. Coroutine Scope
 * 특정한 목적의 "Dispatcher"를 지정하여 제어 및 동작이 가능한 새로운 코루틴 범위를 생성
*/

/**
 * Dispatcher 란?
 *
 * Dispatcher.Default -> 기본적인 백그라운드에서 동작
 * Dispatcher.IO -> 네트워크나 디스크 등, I/O에 사용하는 Dispatcher
 * Dispatcher.Main -> 메인(UI) 스레드에서 동작
 *
 * 이런 Dispatcher 들은 모든 플랫폼에서 지원되는 것은 아니므로
 * 지원되는 플랫폼에 따라서 사용해야 함
 */

/**
 * 코루틴은 이러한 Scope 에서 제어되도록 생성될 수 있음
 *
 * val scope = CoroutineScope(Dispatcher.Default)
 * val coroutineA = scope.launch{}
 * val coroutineB = scope.async{}
 *
 * 위와 같이, 스코프에서 launch(), async() 함수를 통해 새로운 코루틴을 생성할 수 있음
 */

/**
 * launch vs async
 * 코루틴에서의 반환값이 있는지의 여부의 차이
 *
 1. launch
 - 반환값이 없는 Job 객체를 반환

 2. async
 - 반환값이 있는 Deffered 객체를 반환

 launch와 async는 모두 람다함수의 형태를 하고 있고, async는 마지막 값이 반환이 된다.
 */

// 코루틴 사용하려면 아래와 같이 코루틴 관련 라이브러리를 import 해야함


fun main() {

}

