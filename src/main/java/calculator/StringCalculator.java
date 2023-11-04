package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import exception.WrongNumberFormatException;

public class StringCalculator {
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

	public static ArrayList<String> inputFilter(String input) {
		ArrayList<String> inputList = new ArrayList<>();
		boolean custom = false;
		String delimiter = "";
		String replaced = "";

		if (input.isEmpty()) {
			inputList.add("0");
			return inputList;
		}

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

	public static void main(String[] args) throws WrongNumberFormatException {
		FastReader fastReader = new FastReader();
		while (true) {
			String input = fastReader.next();
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
					throw new WrongNumberFormatException();
				} else {
					result += Integer.parseInt(s);
				}
			}
			System.out.println(result);
		}
	}
}