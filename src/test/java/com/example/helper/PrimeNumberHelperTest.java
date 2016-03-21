package com.example.helper;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.helper.PrimeNumberHelper;

public class PrimeNumberHelperTest {

	@Test
	public void testIsPrime() {
		assertFalse(PrimeNumberHelper.isPrime(529));
		assertFalse(PrimeNumberHelper.isPrime(1000000));
		
		assertTrue(PrimeNumberHelper.isPrime(2));
		assertTrue(PrimeNumberHelper.isPrime(47));
		
		
	}

}
