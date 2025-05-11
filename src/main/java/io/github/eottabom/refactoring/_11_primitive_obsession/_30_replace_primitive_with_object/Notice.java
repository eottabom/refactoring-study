package io.github.eottabom.refactoring._11_primitive_obsession._30_replace_primitive_with_object;

public class Notice {

	// @formatter:off
	/*
		현재는 level 을 String 으로 사용하고 있지만,
		코드 상으로 보면 기본형으로 처리하기는 어렵다.
		따라서 클래스로 감싸준다.
		STEP 1) make level class
	 */

//	private String level; // ex: "normal", "urgent", "emergency"

	// STEP 5) 이제는 이 String level 대신에 새로 만든 클래스를 사용한다.
//	private String level; // ex: "normal", "urgent", "emergency"
	private Level level;

	/*
		이 경우는 Type Safety 가 보장되지 않는다.
		-> 지금은 level 이라는 값은 어떠한 값이 다 허용된다.
		따라서, 이 부분을 변경한다.
	 */

//	public Notice(String level) {
//		this.level = level;
//	}
	public Notice(Level level) {
		this.level = level;
	}
	/*
		STEP 2)
		이렇게 하면 Type Safety 가 보장 되긴 하지만,
		Level 에서 보면.. 이것도 String 으로 받게 되어 있어서, 실제로는 Type Safety 가 보장되지 않는다.

		public Level(String value) {
			this.value = value;
		}

		이 경우에는 허용 가능한 값들을 확인하고 설정하면 된다. -> Go to Level class
	 */
	// @formatter:on
//	public Notice(Level level) {
//	}

//	public String getLevel() {
//		return this.level;
//	}

	public Level getLevel() {
		return this.level;
	}
}
