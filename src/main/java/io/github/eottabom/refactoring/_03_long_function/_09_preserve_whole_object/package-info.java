/**
 * 리팩토링9. 객체 통째로 넘기기.
 * Preserve Whole Object
 *
 * 메서드로 넘기는 파라미터들 중에서 여러 파리미터가 있는 경우,
 * 특히, 하나의 오브젝트 또는 레코드에서 파생된 값들인 경우가 있다.
 *
 * 이 경우에 각각을 넘기지 않고, 레코드 또는 오브젝트 타입을 넘기면서 파라미터 갯수를 줄이는 방법이다.
 *
 * Introduce parameter object 과 유사한데,
 * Introduce parameter object 의 경우는 클래스나 레코드가 아예 없을 경우에 처음부터 만들면서,
 * 자연스럽게 Preserve Whole Object 까지 적용되지만,
 *
 * Preserve Whole Object 는 이미 클래스나 레코드가 있는 경우 적용해볼 수 있다.
 *
 * 메서드의 범용성 등이 적절하지 않을 경우 그대로 유지할 수도 있다. (선택사항)
 *
 * 어쩌면 해당 메서드 위치가 적절하지 않을 수도 있다.
 * 이런 경우는 메서드를 옮기는 것에 대해서도 고민해볼 가치가 있다.
 */
package io.github.eottabom.refactoring._03_long_function._09_preserve_whole_object;
