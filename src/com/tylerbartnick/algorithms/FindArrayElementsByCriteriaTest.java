package com.tylerbartnick.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FindArrayElementsByCriteriaTest {

	@Test
	void testFindMinInArrayOfTenShouldEqualFive() {
		int[] arr = new int[] { 77, 18, 5, 91, 19, 10, 147, 1000, 8, 555 };
		int value = FindArrayElementsByCriteria.findMin(arr);
		assertEquals(5, value);
	}

	@Test
	void testFindMinInArrayOfOneShouldEqualNineteen() {
		int[] arr = new int[] { 19 };
		int value = FindArrayElementsByCriteria.findMin(arr);
		assertEquals(19, value);
	}

	@Test
	void testFindMinInEmptyArrayShouldThrowArrayIndexOutOfBoundsException() {
		int[] arr = new int[0];
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			FindArrayElementsByCriteria.findMin(arr);
		});
	}

	@Test
	void testFindMaxInArrayOfTenShouldEqualOneThousand() {
		int[] arr = new int[] { 77, 18, 5, 91, 19, 10, 147, 1000, 8, 555 };
		int value = FindArrayElementsByCriteria.findMax(arr);
		assertEquals(1000, value);
	}

	@Test
	void testFindMaxInArrayOfOneShouldEqualNineteen() {
		int[] arr = new int[] { 19 };
		int value = FindArrayElementsByCriteria.findMax(arr);
		assertEquals(19, value);
	}

	@Test
	void testFindMaxInEmptyArrayShouldThrowArrayIndexOutOfBoundsException() {
		int[] arr = new int[0];
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			FindArrayElementsByCriteria.findMax(arr);
		});
	}

}
