/**
 * 냄새6. 가변 데이터.
 * Mutable Data
 *
 * 변수는 바뀌기 나름이고 자주 변경된다.
 *
 * 데이터 변경으로 인해 생기는 문제가 생긴다.
 * 함수형 프로그래밍 언어는 데이터를 변경하기 않고 복사본을 전달한다.
 * 하지만 그 밖의 프로그래밍 언어는 데이터 변경을 허용하고 있다.
 * 따라서, 데이터 사용할 때 발생할 수 있는 리스크를 관리를 방법을 적용하는 것이다.
 * -> 사이드 이팩트가 발생함.
 *
 * 관련 리팩토링
 * 1) Encapsulate Variable 변수 캡슐화화기
 * - 데이터를 변경할 수 있는 메서드를 제한하고 관리할 수 있다.
 * 2) Split Variable 변수 쪼개기
 * - 여러 데이터를 저장하는 변수를 나눌 수 있다.
 * 3) Slide Statements 코드 정리하기
 * - 데이터를 변경하는 코드를 분리하고 피할 수 있음.
 * 4) Extract Function 함수 추출하기
 * - 데이터를 변경하는 코드로부터 사이드 이팩트가 없는 코드를 분리
 * 5) Separate Query from Modifier 질의 함수와 변경 함수 분리하기
 * - 클라이언트가 원하는 경우에만 사이드 이팩트가 있는 함수를 호출하도록 API 개선 가능
 * 6) Remove Settings Method 세터 제거하기
 * - 가능하다면 제거를 제거해서 데이터가 변경할 수 있는 여지를 제한하는 것.
 * 7) Replace Derived Variable with Query 파생 변수를 질의 함수로 바꾸기
 * - 계산해서 알아낼 수 있는 값에 대해서 적용
 * 8) Combine Functions into Class 여러 함수를 클래스로 묶기 & Combine Functions into Transform 여러 함수를 변환 함수로 묶기
 * - 변수가 사용되는 범위 제한
 * 9) Change Reference to Value 참조를 값으로 바꾸기
 * - 데이터 일부를 변경하기 보다는 데이터 전체를 교체할 수 있다
 */
package io.github.eottabom.refactoring._06_mutable_data;
