package calculator;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import exception.WrongNumberFormatException;

public class StringCalculatorTest {
	/**
	 * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
	 */
	@ParameterizedTest
	@CsvSource(value = {"-0", "1,2-3", "1,2,3-6", "1,2:3-6"}, delimiter = '-')
	void testStringSplitWithCommaAndColon(String input, String expected) throws WrongNumberFormatException {
		input = Optional.ofNullable(input).orElse("");
		int output = testMain(inputFilter(input));
		assertEquals(Integer.parseInt(expected),
			output);
	}

	/**
	 * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의
	 * “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
	 */
	@Test
	@DisplayName("if test string has \"//\" and \"\\n\", it uses a custom delimiter")
	void testStringSplitWithCustomDelimiter() throws Exception {
	    //given
	    String testString = "//;\\n1;2;3";
		int result = 6;

	    //when
		int sum = testMain(inputFilter(testString));

		//then
		assertEquals(result, sum);
	}

	/**
	 * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다
	 */
	@Test
	@DisplayName("If wrong number format strings are typed into calculator"
		+ ", it throws WrongNumberFormatException")
	void testInputThrowsWrongNumberFormatException() throws Exception {
	    //given
	    String testString = "daw21122;12424,dawd";

	    //when

	    //then
		assertThatThrownBy(() -> {
			testMain(inputFilter(testString));
		}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining("잘못된 입력 타입입니다.");
	}
}
