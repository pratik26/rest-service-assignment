/**
 * 
 */
package com.example.controller;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.controller.PrimeNumberRangeController;
import com.example.data.Result;
import com.example.validate.Validator;

/**
 * @author Netra
 *
 */
public class PrimeNumberRangeControllerTest {

	private PrimeNumberRangeController controller = new PrimeNumberRangeController();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.example.controller.PrimeNumberRangeController#computePrimesUsingBasicStrategy(java.lang.String)}.
	 */
	@Test
	public void testComputePrimesUsingBasicStrategy_shouldReturnRangeWhenInputIsValid() {
		assertEquals(new Result(true,null,Arrays.asList(2l,3l,5l,7l)), controller.computePrimesUsingBasicStrategy("10"));
	}

	/**
	 * Test method for {@link com.example.controller.PrimeNumberRangeController#computePrimesUsingJoinForkOptimisedPrimeCheckStrategy(java.lang.String)}.
	 */
	@Test
	public void testComputePrimesUsingJoinForkOptimisedPrimeCheckStrategy_shouldReturnRangeWhenInputIsValid() {
		assertEquals(new Result(true,null,Arrays.asList(2l,3l,5l,7l)), controller.computePrimesUsingJoinForkOptimisedPrimeCheckStrategy("10"));
	}

	/**
	 * Test method for {@link com.example.controller.PrimeNumberRangeController#computePrimesUsingEulerSieveStrategy(java.lang.String)}.
	 */
	@Test
	public void testComputePrimesUsingEulerSieveStrategy_shouldReturnRangeWhenInputIsValid() {
		assertEquals(new Result(true,null,Arrays.asList(2l,3l,5l,7l)), controller.computePrimesUsingEulerSieveStrategy("10"));
	}

	/**
	 * Test method for {@link com.example.controller.PrimeNumberRangeController#isPrime(java.lang.String)}.
	 */
	@Test
	public void testIsPrime_shouldReturnRangeWhenInputIsValid() {
		assertEquals(new Result(true, PrimeNumberRangeController.NUMBER_IS_PRIME,Arrays.asList(7l)), controller.isPrime("7"));
		assertEquals(new Result(true, PrimeNumberRangeController.NUMBER_IS_COMPOSITE,Arrays.asList(8l)), controller.isPrime("8"));
		
	}
	
	/**
	 * Test method for {@link com.example.controller.PrimeNumberRangeController#computePrimesUsingBasicStrategy(java.lang.String)}.
	 */
	@Test
	public void testComputePrimesUsingBasicStrategy_shouldReturnErrorResultWhenInputIsNotValid() {
		assertEquals(new Result(false,Validator.INVALID_INPUT_INPUT_IS_NOT_A_NUMBER_INTEGER,null), 
				controller.computePrimesUsingBasicStrategy("-200.23"));
	}

	/**
	 * Test method for {@link com.example.controller.PrimeNumberRangeController#computePrimesUsingJoinForkOptimisedPrimeCheckStrategy(java.lang.String)}.
	 */
	@Test
	public void testComputePrimesUsingJoinForkOptimisedPrimeCheckStrategy_shouldReturnErrorResultWhenInputIsNotValid() {
		assertEquals(new Result(false,Validator.INVALID_INPUT_INPUT_IS_NOT_A_NUMBER_INTEGER,null), 
				controller.computePrimesUsingJoinForkOptimisedPrimeCheckStrategy("-200.23"));
	}

	/**
	 * Test method for {@link com.example.controller.PrimeNumberRangeController#computePrimesUsingEulerSieveStrategy(java.lang.String)}.
	 */
	@Test
	public void testComputePrimesUsingEulerSieveStrategy_shouldReturnErrorResultWhenInputIsNotValid() {
		assertEquals(new Result(false,Validator.INVALID_INPUT_INPUT_IS_NOT_A_NUMBER_INTEGER,null), 
				controller.computePrimesUsingEulerSieveStrategy("-200.23"));
	}

	/**
	 * Test method for {@link com.example.controller.PrimeNumberRangeController#isPrime(java.lang.String)}.
	 */
	@Test
	public void testIsPrime_shouldReturnErrorResultWhenInputIsNotValid() {
		assertEquals(new Result(false,Validator.INVALID_INPUT_INPUT_IS_NOT_A_NUMBER_INTEGER,null), 
				controller.isPrime("-200.23"));
	}

}
