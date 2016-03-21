package com.example.strategy;

import java.util.List;

/**
 * Interface defining the APIs for strategies that generate prime numbers range
 * 
 * @author Pratik
 *
 */
public interface IPrimeRangeGeneratorStrategy {

	/**
	 * Returns the prime numbers range for the specified limit such that : all primes are less than limit
	 * @param limit Maximum of the range
	 * @return Prime number range
	 */
	public List<Long> getPrimeNumbers (long limit);
}
