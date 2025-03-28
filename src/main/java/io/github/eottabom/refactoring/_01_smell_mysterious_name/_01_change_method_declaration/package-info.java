/**
 * 리팩토링 1. 함수 선언 변경하기.
 * Change Function Declaration
 * 좋은 이름을 가진 함수는 함수가 어떻게 구현되었는지 코드를 보지 않아도 이름만 보고도 이해할 수 있다.
 * 여기서 말하는 '좋은 이름' 을 찾아내는 방법은, 해당 함수가 하는 일에 대해 주석을 작성하고, 주석을 기반으로 함수 이름을 만들어 본다.
 * 함수의 매개 변수는 함수 내부의 문맥을 결정하고, 의존성을 결정한다.
 */
package io.github.eottabom.refactoring._01_smell_mysterious_name._01_change_method_declaration;