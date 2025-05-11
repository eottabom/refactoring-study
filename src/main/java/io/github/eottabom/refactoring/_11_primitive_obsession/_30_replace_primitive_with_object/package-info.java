/**
 * 리팩토링 30. 기본형을 객체로 바꾸기.
 * Replace Primitive with Object
 *
 * 개발 초기에는 얼마든지 데이터를 표현하는데에는 기본형으로 커버가 된다.
 * 하지만, 사용하다보면 기본형으로 커버가 되지 않는 경우가 존재하게 된다.
 * ex) 온도 단위 : 화씨, 섭씨 ..
 *
 * 변화에 유연하게 대처할 수 있게끔 리팩토링을 하는 것이다.
 * 처음부터 완벽한 어플리케이션이 없고, 요구사항은 계속해서 변화하기 때문이다.
 *
 * 기본형을 사용한 데이터를 감사줄 클래스를 만들면, 필요한 기능을 추가할 수 있다.
 */
package io.github.eottabom.refactoring._11_primitive_obsession._30_replace_primitive_with_object;
