/**
 * 리팩토링 18. 변수 쪼개기 Split Variable
 *
 * 어떤 변수가 여러번 재할당 되어도 적절할 때가 있다. 반복문에서 순회하는데 사용되는 변수 또는 인덱스 값을 축적시키는데 사용하는 변수
 *
 * 값을 축적시키는 line 이라는 변수를 재사용하는 것은 자연스러운일이다.
 * <code>
 * 		StringBuilder line = new StringBuilder();
 * 		line.append(participant.username());
 * 		for (int i = 1 ; i <= this.totalNumberOfEvents ; i++) {
 * 			if(participant.homework().containsKey(i) && participant.homework().get(i)) {
 * 				line.append(",O");
 * 			} else {
 * 				line.append(",X");
 * 			}
 * 		}
 * </code>
 * 그 밖에 재할당되는 변수가 있다면, 여러 용도로 사용되는 것이여서 변수를 분리해야 더 이해하기 좋은 코드가 될 수 있다.
 * 하나의 변수에 하나의 책임(Responsibility) 를 지게 한다.
 * 상수를 잘 활용하자.
 */
package io.github.eottabom.refactoring._06_mutable_data._18_split_variable;