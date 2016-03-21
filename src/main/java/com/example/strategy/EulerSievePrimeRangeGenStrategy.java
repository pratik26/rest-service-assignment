/**
 * 
 */
package com.example.strategy;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.LongStream;

/**
 * This strategy class implement Euler Sieve algorithm .
 * It is a version of the sieve of Eratosthenes in which each composite number is eliminated exactly once.
 * 
 * Algorithm:
 * It starts with a list of numbers from 2 to n in order. 
 * On each step the first element is identified as the next prime and the results of multiplying this prime with each 
 * element of the list are marked in the list for subsequent deletion. 
 * The initial element and the marked elements are then removed from the working sequence, and the process is repeated
 * 
 * The complexity is O(n*log(n))
 * @author Pratik
 */
public class EulerSievePrimeRangeGenStrategy implements IPrimeRangeGeneratorStrategy 
{

	/* (non-Javadoc)
	 * @see example.strategy.IPrimeRangeGeneratorStrategy#getPrimeNumbers(long)
	 */
	@Override
	public List<Long> getPrimeNumbers(long limit) 
	{
		BitSet primeList = beginSieve(limit); 
		return LongStream.range(1, limit).parallel().filter(number -> isPrime(number,limit, primeList)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
	
	private boolean isPrime(long num, long maxLimit, BitSet primeList) 
	{ 
	    if( num < maxLimit)
	    {
	        if( (num & 1) == 0) 
	            return ( num == 2); 
	        else 
	            return primeList.get((int)num>>1);
	    }
	    return false;
	} 
    
	/**
	 * Algorithm:
	 * It starts with a list of numbers from 2 to n in order. 
	 * On each step the first element is identified as the next prime and the results of multiplying this prime with each 
	 * element of the list are marked in the list for subsequent deletion. 
	 * The initial element and the marked elements are then removed from the working sequence, and the process is repeated
	 * @param limit The max number in the range
	 * @return Bitset holding the isPrime flags
	 */
	private BitSet beginSieve(long limit) 
    { 
    	BitSet primeList = new BitSet((int)limit>>1); 
        primeList.set(0,primeList.size(),true); 

        int sqRoot = (int) Math.sqrt(limit); 
        primeList.clear(0); 
        for(int num = 3; num <= sqRoot; num+=2) 
        { 
            if( primeList.get(num >> 1) ) 
            { 
                int inc = num << 1;
                for(int factor = num * num; factor < limit; factor += inc) 
                { 
                    primeList.clear(factor >> 1); 
                     
                } 
            } 
        }
        
        return primeList;
    } 

}
