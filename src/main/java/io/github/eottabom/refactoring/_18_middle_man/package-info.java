/**
 * 냄새 18. 중재자.
 * Middle Man
 *
 * message chain 의 반대되는 개념이라고 할 수 있다.
 * message chain 은 코드를 연쇄적으로 메서드나 필드를 참조하면서 메서드를 이어가는 건데,
 * 이걸 중간 중간에 Hide Delegate 로 메시지 체인을 감춘건데,
 * 이 감추는 작업이 많아지면, Middle Man 이라는 냄새가 될 수 있다.
 *
 * 캡슐화는 내부의 기능을 감추는건데,
 * 지나치게 쓰다보면, 클라이언트에서 필요한 코드를 계속 감싸는 느낌이 든다.
 * 그렇다면 이게 Middle Man 에 해당된다.
 *
 * 캡슐화는 무조건 좋은건 아니고, 정도가 있는것이다.
 * 리팩토링이라는 것은 항상 반대가 되는 기술이 존재한다.
 * 존재하는 이유 자체가 코드의 균형을 잡는 것인데,
 * 이건 상황과 여건에 따라서 달라지기도 한다.
 *
 * 캡슐화도 마찬가진데, 감추다보면 무자연스러운 일이 발생하는데 Middle Man 에 해당하는 냄새라고 할 수 있다.
 *
 * 관련 리팩토링
 * 1) Remove Middle Man (중재자 제거하기)
 * - Hide Delegate 와 반대되는 리팩토링 기술
 * 2) Inline Function (함수 인라인)
 * - 메서드 호출하는 쪽으로 코드를 보내서 중재자를 없앤다.
 * 3) Replace Superclass with Delegate (슈퍼클래스를 위임으로 바꾸기)
 * 4) Replace Subclass with Delegate (서브클래스를 위임으로 바꾸기)
 */
package io.github.eottabom.refactoring._18_middle_man;
