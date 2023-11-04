package set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> testSet = Arrays.stream(new Integer[] {1, 2, 3}).collect(Collectors.toSet());;


	/**
	* Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
	 */
	@Test
	@DisplayName("If there are only 3 elements in testSet, its size() returns 3")
	void testSetSize() throws Exception {
	    //given

	    //when
		Integer size = testSet.size();

	    //then
		assertThat(size).isEqualTo(3);
	}

	/**
	 * Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
	 */
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("check if set contains 1, 2, 3 using parameterized test")
	void testSetContains123UsingParameterizedTest(int input) throws Exception {
		assertTrue(testSet.contains(input));
	}

	/**
	 * 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.
	 */
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void testSetContainsUsingAssertEquals(String input, String expected) throws Exception {
		boolean contains = testSet.contains(Integer.valueOf(input));
	    assertEquals(String.valueOf(contains), expected);
	}
}
