package com.example.helper;

/**
 * Class to hold helper APIs
 * @author Pratik
 *
 */
public class PrimeNumberHelper 
{
	
	/**
     * Checks if number is prime or not. Returns true if its prime, else returns 
     * It uses variant of the classic O(sqrt(N)) algorithm
     * Complexity : O(square-root n )
     * This algorithm uses the fact that a prime (except 2 and 3) is of form 6k - 1 and 6k + 1 and 
     * looks only at divisors of this form.
     * @param number Number to check
     * @return
     */
   public static boolean isPrime(long number) 
   {
	   if (number == 2 || number == 3)
		   return true;
	   
	   if (number % 2 == 0 || number % 3 == 0)
        return false;

	   int i = 5;
	   int w = 2;
	   int squareRoot = (int)Math.sqrt(number);
	   while (i  <= squareRoot )
	   {
		   if (number % i == 0)
			   return false;

		   //Optimisations for 6k+/-1 
		   i += w;
		   w = 6 - w;
	   }
    
    return true;

   }

}
