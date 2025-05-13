/**
 * 냄새 17. 메시지 체인.
 * Message Chains
 *
 * 레퍼런스를 따라 계속해서 메서드 호출이 이어지는 코드를 의미한다.
 * ex) this.account.getLoginUser().getUserName().getDescription()
 *
 * 코드를 작성하는 client 쪽에서는 하위에 있는 것들 알아야하고,
 * 엔지니어도 다 알아야 한다..
 * 그리고, 중간에 무언가가 변경이 된 경우 모든 코드를 변경해야한다.
 *
 * 관련 리팩토링
 * 1) Hide Delegate (위임 숨기기)
 * - 일종의 캡슐화 기술이라고 볼 수도 있는데,
 * - 메시지 체인을 캡슐화 시켜서 client 가 최소한 의 정보만 알아도 코드를 작성할 수 있게 한다.
 * 2) Extract Function (함수 추출하기) 로 메시지 체인 일부를 함수로 추출한 다음에
 * Move Function (함수 옮기기) 로 해당 함수를 적절한 곳으로 이동시킬 수 있다.
 */
package io.github.eottabom.refactoring._17_message_chains;
