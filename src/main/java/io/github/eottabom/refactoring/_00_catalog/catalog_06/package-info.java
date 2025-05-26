/**
 * 카탈로그 6. API 리팩토링.
 * 쉽고 이래하고 사용할 수 있는 API 를 만드는 기술
 *
 * http api 만 api 가 아니다.
 * 인터페이스, 클래스, 함수 이런것도 다 API 라고 볼 수 있다.
 * 함수의 선언부를 변경하는 것도 API 리팩토링이라고 할 수 있다.
 *
 * Separate Query from Modifier (질의 함수와 변경 함수 분리하기)
 * Parameterize Function (함수 매개 변수화하기)
 * - 매개변수에 따라서 함수가 하는 일이 달라지게 만들어주는 것이다.
 * - 그렇게 함으로써, 여러 함수들을 만드는 것을 줄일 수 있다면 유용한 리팩토링이 된다는 이야기.
 * Remove Flag Argument (플래그 인수 제거하기)
 * Preserve Whole Object (객체 통째로 넘기기)
 * Replace Parameter with Query (매개 변수를 질의 함수로 바꾸기)
 * Replace Query with Parameter (질의 함수를 매개 변수로 바꾸기)
 * Remove Setting Method (세터 제거하기)
 * Replace Constructor with Factory Function (생성자를 팩토리 함수로 바꾸기)
 * Replace Function with Command (함수를 명령으로 바꾸기)
 * Replace Command with Function (명령을 함수로 바꾸기)
 */
package io.github.eottabom.refactoring._00_catalog.catalog_06;
