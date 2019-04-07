package com.tylerbartnick.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortingTest {

	@Test
	void testSwapShouldSwapIndexOneAndThreeInArrayOfTen() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		Sorting.swap(arr, 1, 3);
		assertArrayEquals(new int[] { 0, 3, 2, 1, 4, 5, 6, 7, 8, 9 }, arr);
	}

	@Test
	void testSwapShouldSwapIndexZeroAndOneInArrayOfTwo() {
		int[] arr = new int[2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		Sorting.swap(arr, 0, 1);
		assertArrayEquals(new int[] { 1, 0 }, arr);
	}

	@Test
	void testSwapShouldThrowArrayIndexOutOfBoundsExceptionOnEmptyArray() {
		int[] arr = new int[0];
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Sorting.swap(arr, 0, 1);
		});
	}

	@Test
	void testBubbleSortAscShouldSortArrayOfOneThousandElementsAsc() {
		int[] arr = new int[1000];
		for (int i = 0, j = 1000; i < 1000 && j > 0; i++, j--) {
			arr[i] = j;
		}

		int[] correctArr = new int[1000];
		for (int i = 0; i < 1000; i++) {
			arr[i] = 0;
		}

		Sorting.bubbleSortAsc(arr);

		assertArrayEquals(correctArr, arr);
	}

	@Test
	void testBubbleSortDescShouldSortArrayOfOneThousandElementsDesc() {
		int[] arr = new int[1000];
		for (int i = 0; i < 1000; i++) {
			arr[i] = i + 1;
		}

		int[] correctArr = new int[1000];
		for (int i = 0, j = 1000; i < 1000 && j > 0; i++, j--) {
			correctArr[i] = j;
		}

		Sorting.bubbleSortDesc(arr);

		assertArrayEquals(correctArr, arr);
	}

}
