package com.tylerbartnick.algorithms;

import java.util.Stack;

public final class ReversePolishNotationCalculator {

	private Stack<String> stack;

	public ReversePolishNotationCalculator() {
		this.stack = new Stack<>();
	}

	public double calculate(String expression) {

		if (expression.trim() == "")
			return 0.0d;

		String[] tokens = this.tokenizeExpression(expression);
		double op1, op2;

		for (String token : tokens) {
			if (!this.isOperator(token)) {
				this.stack.push(token);
			} else {
				op2 = Double.parseDouble(this.stack.pop());
				op1 = Double.parseDouble(this.stack.pop());
				this.stack.push(String.valueOf(this.reduce(op1, op2, token)));
			}
		}

		return Double.parseDouble(this.stack.pop());

	}

	private String[] tokenizeExpression(String expression) {

		return expression.split(" ");

	}

	private boolean isOperator(String op) {
		switch (op) {
		case "+":
		case "-":
		case "*":
		case "/":
			return true;
		default:
			return false;
		}
	}

	private double reduce(double operand1, double operand2, String operator) {
		switch (operator) {
		case "+":
			return this.add(operand1, operand2);
		case "-":
			return this.subtract(operand1, operand2);
		case "*":
			return this.mulitply(operand1, operand2);
		case "/":
			return this.divide(operand1, operand2);
		default:
			return 0.0d;
		}
	}

	private double add(double operand1, double operand2) {
		return operand1 + operand2;
	}

	private double subtract(double operand1, double operand2) {
		return operand1 - operand2;
	}

	private double mulitply(double operand1, double operand2) {
		return operand1 * operand2;
	}

	private double divide(double operand1, double operand2) {
		return operand1 / operand2;
	}

}