package deemoKotlin

// '0'10010101001001010..010
// 맨 앞의 0은 부호 bit

/**
 * shr, shl -> 부호 비트를 포함하지 않고 비트를 오른쪽, 왼쪽으로 이동
 * ushr -> 부호 비트를 포함하여 모든 비트를 오른쪽으로 이동
 */

/**
 * 비트 연산자들
 * and, or, xor(같으면 0, 다르면 1)
 *
 * inv() -> 비트를 반전 (0 <-> 1)
 */

fun main() {
    var bitData:Int = 0b10000   // 하위 5번째 비트에 10000 채움, 나머지 상위 비트들은 0으로 채워짐
    bitData = bitData or (1 shl 2)  // 세번째 비트를 set 하는 방법  // 1 shl 2 -> 100
    println(bitData.toString(2))    // toString의 패러미터로 진법 변환이 가능하다
}