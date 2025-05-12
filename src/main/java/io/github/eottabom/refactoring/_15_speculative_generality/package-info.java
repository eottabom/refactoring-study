/**
 * 냄새 15. 추측성 일반화.
 * speculative Generality
 *
 * 지금 당장 불필요함에도 불고, 앞으로 필요할 것 같애 라고 하면서 만들기 시작하면서,
 * 코드가 늘어나는 경우지만, 결국엔 쓰이지 않는 코드를 말한다.
 *
 * 예를 들어서,
 * 5개 사면 10% 할인! 이 요구사항이었는데,
 * 15%, 20% 할인에 대한 룰은 만들기 시작하고 규칙을 만들기 시작하면...
 * 이때 부터 문제가 발생. -> 불필요한 코드, 클래스가 생기게 된다.
 * 이런게 추측성 일반화 라고 한다.
 *
 * XP 의 YAGNI (You aren't gonna need it) 원칙을 따르자.
 * 지금 당장 필요한게 아니면 만들지마. 라는 것
 *
 * Lazy element 와 유사한 측면이 있긴하다.
 *
 * 관련 리팩토링
 * 1) Collapse Hierarchy (계층 합치기)
 * - 추상 클래스를 만들었지만 유효하지 않을 경우
 * 2) Inline Function (함수 인라인) or Inline Class (클래스 인라인)
 * - 불필요한 위임
 * 3) Change Function Declaration (함수 선언 변경하기)
 * - 사용하지 않는 매개변수를 가진 함수
 * 4) Remove Dead code (죽은 코드 제거하기)
 * - 오로지 테스트 코드에서만 사용하는 코드
 */
package io.github.eottabom.refactoring._15_speculative_generality;
