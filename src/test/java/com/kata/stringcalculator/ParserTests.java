package com.kata.stringcalculator;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class ParserTests {

	private Parser parser;
	
	@Before
	public void setUp() throws Exception {
		parser = new Parser();
	}

    @Test
    public void emptyStringShouldReturnTheSame() {
    	String[] expected = {""};
    	String[] resultado = parser.parse("");
    	
    	assertTrue(Arrays.equals(expected,resultado));
    }
    
    @Test
    public void inputShouldReturnSinglesNumbers() {
    	String[] expected = {"1","2","3"};
    	String[] resultado = parser.parse("1,2,3");
    	
    	assertTrue(Arrays.equals(expected,resultado));
    }
    
    @Test
    public void newLineCharacterSeparatorIsSupported() {
    	String input = "1\n2,3";
    	String[] expected = {"1","2","3"};
    	String[] resultado = parser.parse(input);
    	
    	assertTrue(Arrays.equals(expected,resultado));
    }
    
    @Test
    public void inputSpecifieNewDelimiterSemicolon() {
    	String input = "//;\n1;2";
    	String[] expected = {"1","2"};
    	String[] resultado = parser.parse(input);
    	
    	assertTrue(Arrays.equals(expected,resultado));
    }
    
	
	
}
