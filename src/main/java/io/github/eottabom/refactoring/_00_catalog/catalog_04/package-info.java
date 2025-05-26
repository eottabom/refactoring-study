/**
 * 카탈로그 4. 데이터 조직화.
 * 데이터(변수가 필드) 구조를 다루는 기술
 *
 * Split Variable (변수 쪼개기)
 * Rename Field (필드 이름 바꾸기)
 * Replace Derived Variable with Query (파생 변수를 질의 함수로 바꾸기)
 * - 계산할 수 있는 변수를 굳이 필드로 선언하지 말자는 것.
 * - 다른 변수들을 통해서 계산할 수 있는 것은 함수로 바꾸자는 것.
 * Change References to Value (참조를 값으로 바꾸기)
 * - 어떤 매개변수를 다룰 때 참조가 아니라 값을 전달한다는 것.
 * - Reference 의 값을 많이 쓴다면 적절하겟지만 값하나만 쓰는 거면 값 하나만 전달한다는 것.
 * Change Value to References (값을 참조로 바꾸기)
 */
package io.github.eottabom.refactoring._00_catalog.catalog_04;
