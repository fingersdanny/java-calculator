package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

	/**
	*  "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
	 */
	@Test
	@DisplayName("if string \"1,2\" is split with comma, the result array must contain both \"1\", \"2\".")
	void testSplitString1_2WithComma() throws Exception {
	    //given
		String testString = "1,2";

	    //when
		String[] testStringArray = testString.split(",");

	    //then
		assertThat(testStringArray).contains("1", "2");
	}

	/**
	* "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
	 */
	@Test
	@DisplayName("if string \"1\" is split with comma, the result array must contain \"1\".")
	void testSplitString1WithComma() throws Exception {
		//given
		String testString = "1";

		//when
		String[] testStringArray = testString.split(",");

		//then
		assertThat(testStringArray).containsExactly("1");
	}

	/**
	 * "(1,2)" 값이 주어졌을 때 String의 substring 메소드를 활용해 () 제거하고 "1,2"를 반환하도록 구현한다.
	 */
	@Test
	@DisplayName("if string \"(1,2)\" sliced using String.substring, it returns \"1,2\" ")
	void testSubstringToRemoveBrackets() throws Exception {
	    //given
		String testString = "(1,2)";

	    //when
		String replacedString = testString.replace("(", "").replace(")", "");

		//then
		assertThat(replacedString).isEqualTo("1,2");
	}

	/**
	 * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
	 */
	@Test
	@DisplayName("if string \"abc\" sliced using charAt(2), it returns \"c\"")
	void testStringCharAt2() throws Exception {
	    //given
		String testString = "abc";

	    //when
		Character character = testString.charAt(2);

		//then
		assertThat(testString.charAt(2)).isEqualTo(character);
	}

	/**
	 * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
	 * StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
	 */
	@Test
	@DisplayName("if string \"abc\" sliced using charAt(3), it returns StringIndexOutofExcetion")
	void testStringCharAtThrowsStringIndexOutofException() throws Exception {
	    //given
	    String testString = "abc";

	    //when
		Integer index = 3;

	    //then
		assertThatThrownBy(() -> {
			testString.charAt(index);
		})
			.isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("index out of range: 3");
	}
}
