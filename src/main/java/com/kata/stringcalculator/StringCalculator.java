package com.kata.stringcalculator;

/**
 * StringCalculator sum numbers from a input string
 * the numbers must be separated by <,> or <\\n>
 * 
 *   @see Parser
 */
public class StringCalculator {

	Parser parser;
	
	public StringCalculator() {
		parser = new Parser();
	}

	public int add(String input) {
		
		if ("".equals(input))
			return 0;
		
		int result = AddOperation(input);
		return result;
	}

	private int AddOperation(String input) {
		int result = 0;
		String[] values = parser.parse(input);
		for (String value : values) {
			result += convertToInt(value);
		}
		return result;
	}

	private int convertToInt(String value) {
		return Integer.parseInt(value);
	}
}
