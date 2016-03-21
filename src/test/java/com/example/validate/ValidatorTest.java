package com.example.validate;



import static org.junit.Assert.*;

import org.junit.Test;

import com.example.validate.Validator;



public class ValidatorTest 
{

	@Test
	public void testValidateLimit_shouldValidateWhenValidLimitIsPassed() 
	{
		assertEquals(Validator.validateLimit("10000"), 10000l);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidateLimit_shouldThrowExceptionWhenLimitIsNull() 
	{
		Validator.validateLimit(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testValidateLimit_shouldThrowExceptionWhenLimitIsNotAnInteger() 
	{
		Validator.validateLimit("1.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidateLimit_shouldThrowExceptionWhenLimitIsLessThan2() 
	{
		Validator.validateLimit("1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidateLimit_shouldThrowExceptionWhenLimitIsGreaterThanThreshold() 
	{
		Validator.validateLimit(new Long(Validator.THRESHOLD + 1).toString());
	}
	
}
