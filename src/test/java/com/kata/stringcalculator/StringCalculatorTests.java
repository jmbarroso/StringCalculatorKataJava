package com.kata.stringcalculator;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTests {

	StringCalculator stringCalculator;
	
	@Before
	public void setUp() throws Exception {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void emptyInputShouldReturn0() throws Exception {
		String input = "";
		assertEquals("Empty input should return 0", 0, stringCalculator.add(input));
	}
	
	@Test
	public void singleNumberInInputShouldReturnTheSameNumber() throws Exception {
		assertEquals(0, stringCalculator.add("0"));
		assertEquals(1, stringCalculator.add("1"));
		assertEquals(2, stringCalculator.add("2"));
	}
	
	@Test
	public void NumbersInInputShouldReturnSum() throws Exception {
		assertEquals(1, stringCalculator.add("0,1"));
		assertEquals(3, stringCalculator.add("1,2"));
		assertEquals(5, stringCalculator.add("2,3"));
		assertEquals(6, stringCalculator.add("2,3,1"));
	}
	
	@Test
	public void ShouldReturnSumUsingNewLineDelimiter() throws Exception {
		assertEquals(1, stringCalculator.add("0\n1"));
		assertEquals(3, stringCalculator.add("1\n2"));
		assertEquals(5, stringCalculator.add("2\n3"));
		assertEquals(6, stringCalculator.add("2,3\n1"));
	}
	
	@Test
	public void ShouldReturnSumUsingNewDelimiter() throws Exception {
		String input = "//;\n2;2";
		assertEquals(4, stringCalculator.add(input));
	}
	
}
