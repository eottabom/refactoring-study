/**
 * 카탈로그 3. 기능 옮기기.
 * 함수나 필드 또는 문장을 적절한 위치로 옮기는 기술.
 *
 * Move Function (함수 옮기기)
 * Move Field (필드 옮기기)
 * Move Statements into Function (문장을 함수로 옮기기) <-> Move Statements to Callers (문장을 호출한 곳으로 옮기기)
 * - statements 를 함수 안으로 옮기는 것
 * - 항상 호출되는 statements 는 함수 안으로 옮기는 것이 더 적절하다는 것이다.
 * Move Statements to Callers (문장을 호출한 곳으로 옮기기) <-> Move Statements into Function (문장을 함수로 옮기기)
 * - 문장을 함수를 호출하는 곳으로 옮기는 것
 * - 함수 추출하기를 다시 하고 싶은 경우에 사용
 * - 하나의 Statement 에 대해서 적절한 위치를 찾아주는 리팩토링 기술
 * Replace Inline Code with Function Call (인라인 코드를 함수 호출로 바꾸기)
 * - Inline 된 코드가 여러번 사용되면 함수로 변경하는 것
 * Slide Statements (문장 슬라이드 하기)
 * - 코드를 정리하다보면 위아래로 내리기만해도 그 부분을 줄일 수 있다.
 * Split Loop (반복문 쪼개기)
 * - 반복문 안에서 여러가지 일을 하니깐 하나의 Function 으로 추출하는 것이고, 필드가 옮겨질수도 있다.
 * Replace Loop with Pipeline (반복문을 파이프라인으로 바꾸기)
 * Remove Dead Code (죽은 코드 제거하기)
 */
package io.github.eottabom.refactoring._00_catalog.catalog_03;
