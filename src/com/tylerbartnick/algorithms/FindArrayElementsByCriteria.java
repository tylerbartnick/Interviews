package com.tylerbartnick.algorithms;

public class FindArrayElementsByCriteria {

	public static int findMin(int[] arr) {
		int curr = arr[0];
		for (int i : arr) {
			if (i < curr) {
				curr = i;
			}
		}

		return curr;
	}

	public static int findMax(int[] arr) {
		int curr = arr[0];
		for (int i : arr) {
			if (i > curr) {
				curr = i;
			}
		}

		return curr;
	}

}
