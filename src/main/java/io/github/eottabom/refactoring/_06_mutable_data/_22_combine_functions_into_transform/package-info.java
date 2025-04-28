/**
 * 리팩토링 22. 여러 함수를 변환 함수로 묶기.
 * Combine Functions into Transform
 *
 * 관련있는 여러 파생 변술르 만들어낸 함수가 여러 곳에서 사용한다면,
 * 변한 함수를 통해서 한 곳으로 모으는 것이다.
 *
 * 변환함수를 통해서 새로운 데이터로 만드는 것이다.
 *
 * 굳이 파생 변수를 만들어내는 여러 함수들을 여러 곳에서 반복해서 쓰지 않아도 된다.
 *
 * 여러 함수를 클래스로 묶기와 여러 함수를 트랜스폼으로 묶기는,
 * 소스에 해당되는 데이터가 setter 를 가진 데이터라면, 클래스로 묶는게 적절하다.
 * Why?
 * - 가변 데이터, Mutable variable 에도 동일하게 적용할 수 있다.
 * - 소스 데이터가 매번 변하기 때문에 derived variable 을 쓰고 싶지 않기 때문에,
 * 메서드를 클래스로 묶어서 제공하는 것이 좋다.
 *
 * 소스 데이터가 변경되지 않는 경우는
 * transform function 을 하거나 Combine Functions into class 을 해도 무방하다.
 * 
 */
package io.github.eottabom.refactoring._06_mutable_data._22_combine_functions_into_transform;
