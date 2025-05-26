/**
 * 리팩토링 42. 레코드 캡슐화하기.
 * Encapsulate Record
 *
 * 변수 캡슐화하기와 유사항 리팩토링.
 * 책에서 말하는 레코드를 자바의 레코드와 완전히 일치하지는 않다.
 * 여기서 레코드랑 public 필드로 구성된 데이터 클래스를 의미한다.
 *
 * 이 레코드를 public 필드로 구성하게 되면 어디서든 변경이 가능해서 어떻게 변경될지 예측할 수가 없다.
 * 따라서 문제가 생길 여지가 많아져서 Encapsulate 를 해서,
 * public 한 메서드를 통해서만 접근 가능하게 캡슐화하는 것이다.
 *
 * 자바에서는 Record 는 불변 객체라서 이런 리팩토링이 필요 없다.
 */
package io.github.eottabom.refactoring._22_data_class._42_encapsulate_record;
