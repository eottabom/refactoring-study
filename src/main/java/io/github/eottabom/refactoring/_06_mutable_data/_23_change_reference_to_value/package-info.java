/**
 * 리팩토리 23. 참조를 값으로 바꾸기.
 * Change Reference to Value.
 *
 * MutableValues 의 완전한 반대에 해당하는 리팩토링
 * 변하는 값을 변하지 않는 Value Object 로 바꾸는것은 흔하지만,
 * 
 * Reference 객체 vs Value 객체
 * - Reference Object 는 얼마든지 객체의 값이 변하는 객체
 * - Value Object 는 어떤 객체의 동일성을 그 객체가 가지고 있는 필드이 값들로 판단하는 객체 -> 불변 객체
 *
 * 어떤 경우에 Reference vs Value 을 사용하는지의 대한 기준은 여러가지지만,
 * 객체 변경 사항을 다른 코드에도 전파시키고 있다면 Reference,
 * Value Object 는 변경 내역이 오로지 한정된 곳에서만 반영되게 하려면 사용. -> 변경사항 적용을 최소화하고 싶다면 Value Object
 */
package io.github.eottabom.refactoring._06_mutable_data._23_change_reference_to_value;