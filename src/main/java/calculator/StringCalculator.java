package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import exception.WrongNumberFormatException;

public class StringCalculator {
	public static ArrayList<String> inputFilter(String input) {
		ArrayList<String> inputList = new ArrayList<>();
		boolean custom = false;
		String delimiter = "";

		if (input == null) {
			inputList.add("0");
			return inputList;
		}
		String replaced = input;

		if (input.startsWith("//")) {
			int startIndex = input.indexOf("//");
			int endIndex = input.indexOf("\\n");
			replaced = input.replace("//", "").replace("\\n", "");
			delimiter = input.substring(startIndex + 2, endIndex);
			custom = true;
		}

		String[] inputArray = replaced.split(":");
		for (String s : inputArray) {
			String[] split = s.split(",");
			if (custom) {
				for (String temp : split) {
					String[] lastSplit = temp.split(delimiter);
					inputList.addAll(Arrays.stream(lastSplit).collect(Collectors.toList()));
				}
			} else {
				inputList.addAll(Arrays.stream(split).collect(Collectors.toList()));
			}
		}

		return inputList;
	}

	public static int testMain(List<String> inputList) throws WrongNumberFormatException{
		int result = 0;
		boolean accept = true;
		for (String s : inputList) {
			accept = true;
			if (s.isEmpty()) {
				continue;
			}
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (!Character.isDigit(c)) {
					accept = false;
					break;
				}
			}

			if (!accept) {
				throw new WrongNumberFormatException("잘못된 입력 타입입니다.");
			} else {
				result += Integer.parseInt(s);
			}
		}
		return result;
	}


	public static void main(String[] args) throws WrongNumberFormatException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.next();
			if (input.equals("off")) {
				break;
			}
			ArrayList<String> inputList = inputFilter(input);
			int result = 0;
			boolean accept = true;
			for (String s : inputList) {
				if (s.isEmpty()) {
					continue;
				}
				for (int i = 0; i < s.length(); i++) {
					char c = s.charAt(i);
					if (!Character.isDigit(c)) {
						accept = false;
						break;
					}
				}

				if (!accept) {
					throw new WrongNumberFormatException("잘못된 입력 타입입니다.");
				} else {
					result += Integer.parseInt(s);
				}
			}
			System.out.println(result);
		}
	}
}