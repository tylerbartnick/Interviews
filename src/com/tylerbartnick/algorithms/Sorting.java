package com.tylerbartnick.algorithms;

public final class Sorting {

	public static void bubbleSortAsc(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < (arr.length - i) - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void bubbleSortDesc(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < (arr.length - i) - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int idx1, int idx2) {

		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;

	}

}