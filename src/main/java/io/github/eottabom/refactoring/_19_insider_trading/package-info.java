/**
 * 냄새 19. 내부자 거래
 * Insider Trading
 *
 * 어떤 모듈이 다른 모듈에 있는 내부 정보를 지나치게 많이 알고 있는 경우를 말한다.
 * -> 강한 결합이 생길 수 있음
 *
 * 적절한 모듈로 "Move Function" 과 "Move Field" 를 사용해서 결합을 낮추거나,
 *
 * 공통적인 기능은 새로운 모듈을 만들어 관리하거나,
 * Hide Delegate 를 사용해 특정 모듈을 중재자처럼 사용하거나,
 *
 * 상속으로 인한 결합도를 줄일 때 "슈퍼 클래스 또는 서브 클래스로 위임으로 대체하기" 를 사용할 수 있다.
 */
package io.github.eottabom.refactoring._19_insider_trading;
