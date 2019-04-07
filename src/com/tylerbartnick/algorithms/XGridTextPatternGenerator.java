package com.tylerbartnick.algorithms;

public final class XGridTextPatternGenerator {

	private static final int BOUND = 100;

	public static void main(String[] args) {

		int rows = BOUND;
		int cols = BOUND;
		char _char = '#';
		StringBuilder board = new StringBuilder();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if ((i == 0 || i == rows - 1) || (j == 0 || j == cols - 1) || (i + j == BOUND - 1) || (i == j)) {
					board.append(_char);
				} else {
					board.append(" ");
				}
			}

			board.append("\n");

		}

		System.out.print(board);
	}

}