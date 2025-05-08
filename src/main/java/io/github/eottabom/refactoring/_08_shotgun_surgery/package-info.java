/**
 * 냄새 8. 산탄총 수술.
 * Shotgun Surgery
 * 
 * 어떠한 어플리케이션의 변경 사항이 있을 때, 여러 모듈을 손대서 수정해야하는 상황
 * 여러 곳을 수정해야 한다는 것은, 코드의 응집도나 결합도가 좋지 않다는 것을 의미한다. (응집도 up, 결합도 down)
 *
 * Divergent Change(뒤엉킨 변경) 과 상당히 유사한데,
 * 응집도가 낮고, 결합도가 높아서 이런 일이 생기는데,
 * Divergent Change 의 경우는 여러가지 이유로 하나의 클래스를 수정해야 하는 경우를 의미하지만,
 * Shotgun Surgery 의 경우는 반대로 하나의 일로 여러 곳을 손봐야 하는 경우이다.
 *
 * 관련된 리팩토링 기술
 * 1) Move Function(함수 옮기기) + Move Field(필드 옮기기)
 * - 변경이 필요한 내역을 하나의 클래스로 모을 수 있음
 * 2) Combine Functions into Class(여러 함수를 클래스로 묶기) 
 * - 비슷한 데이터를 사용하는 여러 함수가 있을 경우
 * 3) Split Phase(단계 쪼개기)
 * - 공통으로 사용하는 함수의 결과물들을 하나로 묶는다.
 * 4) Inline Function(함수 인라인) + Inline Class(클래스 인라인)
 * - 흩어진 로직을 한 곳으로 모은다.
 *
 */
package io.github.eottabom.refactoring._08_shotgun_surgery;
