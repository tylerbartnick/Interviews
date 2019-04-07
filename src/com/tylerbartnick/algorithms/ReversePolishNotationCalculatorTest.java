package com.tylerbartnick.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReversePolishNotationCalculatorTest {

	@Test
	void testCalculatorWithSimpleExpressionShouldEqualTen() {
		ReversePolishNotationCalculator calc = new ReversePolishNotationCalculator();
		double value = calc.calculate("8 2 +");
		assertEquals(10, value);
	}

	@Test
	void testCalculatorWithComplexExpressionShouldEqualFive() {
		ReversePolishNotationCalculator calc = new ReversePolishNotationCalculator();
		double value = calc.calculate("15 7 1 1 + - / 3 * 2 1 1 + + -");
		assertEquals(5, value);
	}

	@Test
	void testCalculatorWithEmptyStringShouldEqualZero() {
		ReversePolishNotationCalculator calc = new ReversePolishNotationCalculator();
		double value = calc.calculate("");
		assertEquals(0, value);
	}

	@Test
	void testCalculatorWithSingleSpaceShouldEqualZero() {
		ReversePolishNotationCalculator calc = new ReversePolishNotationCalculator();
		double value = calc.calculate("");
		assertEquals(0, value);
	}

}
