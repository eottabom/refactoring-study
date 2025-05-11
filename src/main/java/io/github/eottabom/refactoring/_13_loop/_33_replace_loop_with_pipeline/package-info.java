/**
 * 리팩토링 33. 반복문을 파이프라인으로 바꾸기.
 * Replace Loop with Pipeline
 *
 * 콜렉션 파이프라인 (Java 의 stream, C# 의 LINQ)
 * 이 기능을 사용하게 되면 Operation 을 통해서 표현가능하다.
 * 중간에 처리하는 Operation, 종료하는 Operation 이 존재한다.
 * ex) 
 * filter : 전달 받은 조건의 true 에 해당하는 데이터만 다음 오퍼레이션으로 전달
 * map : 전달 받은 "함수"를 사용해 입력값을 원하는 출력값으로 변환하여 다음 오퍼레이션으로 전달
 * 
 */
package io.github.eottabom.refactoring._13_loop._33_replace_loop_with_pipeline;
