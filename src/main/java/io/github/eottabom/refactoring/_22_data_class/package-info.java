/**
 * 냄새 22. 데이터 클래스.
 * Data Class
 *
 * 클래스 안에 적절한 메서드 없이 필드만 있는 경우이다.
 *
 * 데이터 클래스는 getter, setter 만 있는 클래스
 *
 * public 필드를 가지고 있다면 Encapsulate Record (레코드 캡슐화하기) 를 사용해 getter, setter 를 통해 접근을 고칠 수 있다.
 * 변경되지 않아야 할 필드는 Remove Setting Method (세터 제거하기) 를 적용할 수 있다.
 * getter, setter 가 사용되는 메서드를 찾아보고 Move Function (함수 옮기기) 를 사용해서 데이터 클래스로 옮길 수 있고,
 * 메서드 전체가 아닌 일부 코드만 옮겨야한다면 Extract Function (함수 추출하기) 를 통해서 옮길 수 있다.
 *
 */
package io.github.eottabom.refactoring._22_data_class;
