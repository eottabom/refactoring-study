/**
 * 번외. Record keyword.
 * Record 자료 구조의 필드 이름은 프로그램 전반에 걸쳐 참조되고, 이때 이 이름이 많이 사용되서 더욱 더 중요하다.
 * Java 14 버전 부터는 Record 라는 keyword 를 지원한다.
 * 일단, Record 라는 자료구조는 비슷한 류의 데이터를 하나의 클래스로 모아놓은 것이다.
 * 중요한 특징은 불변하다는 것이다.
 * 기존에도 Record 라는 keyword 가 나오기 전부터 비슷하게 사용은 했을 것이다.
 * final 을 활용하고 setter 를 만들지 않고.. 여러 조건을 만족시켜야했었지만..
 * HashCode, Equals 를 잘 구현해야했다.
 * HashCode 같은 경우는 동일한 필드의 값을 가졌다면, 같은 해시코드가 나와야 되고,
 * Equals 는 같다고 해야하고..
 * Record 라는 keyword 를 사용하면 그런거 없이 간단하게 사용할 수 있다.
 */
package io.github.eottabom.refactoring._01_smell_mysterious_name._04_using_record;