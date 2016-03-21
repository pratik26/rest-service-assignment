package com.example.validate;

public class Validator {

	public static final String INVALID_INPUT_INPUT_NEEDS_TO_BE_GREATER_THAN_1 = "Invalid input. Input needs to be greater than 1";
	public static final String INVALID_INPUT_INPUT_IS_NOT_A_NUMBER_INTEGER = "Invalid input. Input is not a number/integer";
	final public static long THRESHOLD = 100000000L; 
	public static final String INVALID_INPUT_INPUT_IS_GREATER_THAN_THRESHOLD = "Invalid input. Input is greater than threshold " + THRESHOLD;
	
	
	/**
	 * Validates Limit.
	 * Throws Exception if :
	 * (1) Limit is null
	 * (1) Limit is not a number
	 * (2) Limit is < 2
	 * (3) Limit is greater than threshold : 10^8
	 * @param limit Input
	 * @return If validation is successful, Limit in numeric form. Otherwise, exception
	 */
	public static long validateLimit(String limit)
	{
		long limitNumber = 0;
		try
		{
			limitNumber = Long.parseLong(limit);
		}
		catch(NumberFormatException nfe)
		{
			throw new IllegalArgumentException(INVALID_INPUT_INPUT_IS_NOT_A_NUMBER_INTEGER);
		}
		
		if ( limitNumber <  2 )
		{
			throw new IllegalArgumentException(INVALID_INPUT_INPUT_NEEDS_TO_BE_GREATER_THAN_1);
		}
		
		if ( limitNumber >  THRESHOLD )
		{
			throw new IllegalArgumentException(INVALID_INPUT_INPUT_IS_GREATER_THAN_THRESHOLD );
		}
		
		return limitNumber;
	}
}
