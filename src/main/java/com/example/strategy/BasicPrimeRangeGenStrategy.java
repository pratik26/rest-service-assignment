/**
 * 
 */
package com.example.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

/**
 * This strategy class implement basic algorithm :
 * (1) Iterate over the range ( 2, limit ) in parallel and check if each number is prime or composite
 * (2) If its prime, add to the result
 * The complexity is O(n*sqrt(n))
 * @author Pratik
 */
public class BasicPrimeRangeGenStrategy implements IPrimeRangeGeneratorStrategy 
{

	/* (non-Javadoc)
	 * @see example.strategy.IPrimeRangeGeneratorStrategy#getPrimeNumbers(long)
	 */
	@Override
	public List<Long> getPrimeNumbers(long limit) 
	{
		return LongStream.range(1, limit).parallel().filter(this::isPrime).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
	
	/**
	 * Returns true if number is prime, otherwise false
	 * Time complexity of algorithm is O(sqrt(n))
	 * @param number  Input Number
	 * @return True if number is prime. Otherwise false
	 */
    boolean isPrime(long number) 
    {
        return number > 1 && LongStream.rangeClosed(2, (long) Math.sqrt(number)).noneMatch(divisor -> number % divisor == 0);
    }

}
