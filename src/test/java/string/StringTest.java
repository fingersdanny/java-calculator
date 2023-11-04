package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {
	@Test
	@DisplayName("if string \"1,2\" is split with comma, the result array contains both \"1\", \"2\".")
	void testSplitStringWithComma() throws Exception {
	    //given
		String testString = "1,2";

	    //when
		String[] testStringArray = testString.split(",");

	    //then
		assertThat(testStringArray).contains("1", "2");
	}
}
