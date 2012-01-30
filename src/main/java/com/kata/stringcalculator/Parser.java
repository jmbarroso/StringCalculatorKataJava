package com.kata.stringcalculator;

/**
 * Process an input string and return the values
 * splitting by separators
 *
 */
public class Parser {
	
	private static final String SEPARATOR_COMMA = ",";
	private static final String SEPARATOR_NEW_LINE = "\\n";
	
	private String parseRegex;
	
	public Parser() {
		parseRegex = SEPARATOR_COMMA + "|" + SEPARATOR_NEW_LINE;
	}
	
	public String[] parse(String input) {
		if (hasOptionalDelimiter(input)) {
			input = extractAndProcessOptionalDelimiter(input);
		}
		return extractValues(input);
	}

	private boolean hasOptionalDelimiter(String input) {
		if (input.matches("//(.)\n.+")) // TODO ÀGeneralize? 
			return true;
		return false;
	}
	
	private String extractAndProcessOptionalDelimiter(String input) {
		String optionalSeparator = input.substring(2,3); 
		parseRegex += "|"+ optionalSeparator;
		input = input.substring(4);
		return input;
	}
	
	private String[] extractValues(String input) {
		return input.split(parseRegex);
	}
	
}
