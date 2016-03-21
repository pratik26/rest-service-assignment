package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.Result;
import com.example.helper.PrimeNumberHelper;
import com.example.strategy.BasicPrimeRangeGenStrategy;
import com.example.strategy.EulerSievePrimeRangeGenStrategy;
import com.example.strategy.ForkJoinAndOptimisedPrimeCheckPrimeRangeGenStrategy;
import com.example.strategy.IPrimeRangeGeneratorStrategy;
import com.example.validate.Validator;

/**
 * Controller that exposes prime number service APIs : prime number range and prime number check
 * @author Pratik
 *
 */
@RestController
public class PrimeNumberRangeController {
	static final String NUMBER_IS_COMPOSITE = "Number is Composite";

	static final String NUMBER_IS_PRIME = "Number is Prime";

	final private static String LOG_FORMAT = "Time taken for generating primes using %s is %d s";
	
	//Right now, directly setting the dependencies. Ideally, need to be injected ( through Spring )
	//Also, typically would need only one
    private IPrimeRangeGeneratorStrategy basicStrategy = new BasicPrimeRangeGenStrategy();
    private IPrimeRangeGeneratorStrategy forkJoinOptPrimeCheckStrategy = new ForkJoinAndOptimisedPrimeCheckPrimeRangeGenStrategy();
    private IPrimeRangeGeneratorStrategy eulerSievePrimeRangeGenStrategy = new EulerSievePrimeRangeGenStrategy();
    
    /**
     * Checks is the number is prime or not.
     * On exception, Result object with failure flag and message set is returned.
     * Uses  @see example.helper.PrimeNumberHelper#isPrime(long) for primary number check 
     * @param number Number to check
     * @return Result object
     */
    @RequestMapping("/isPrime")
    public Result isPrime(@RequestParam(value="number") String numberString) 
    {
    	try
    	{
    		long number = Validator.validateLimit(numberString);
    		boolean isPrime = PrimeNumberHelper.isPrime(number);
    		return new Result(true, isPrime ? NUMBER_IS_PRIME : NUMBER_IS_COMPOSITE , Arrays.asList(number));
    	}
    	catch(Exception e)
    	{
    		//e.printStackTrace();
    		return new Result(false, e.getMessage() , null);
    	}
    }

    /**
     * Computes prime number range for the specified limit and returns result as json.
     * On exception, Result object with failure flag and message set is returned.
     * Uses  @see example.strategy.BasicPrimeRangeGenStrategy to compute the range 
     * @param maxNumber Limit
     * @return Result object
     */
    @RequestMapping("/findPrimeBasic")
    public Result computePrimesUsingBasicStrategy(@RequestParam(value="number") String maxNumber) 
    {
    	try
    	{
    		long limit = Validator.validateLimit(maxNumber);
    		long begin = System.currentTimeMillis();
    		List<Long> result = basicStrategy.getPrimeNumbers(limit);
    		System.out.println(String.format(LOG_FORMAT, "Basic", (System.currentTimeMillis()-begin)/1000));
    		return new Result(true, null , result);
    	}
    	catch(Exception e)
    	{
    		//e.printStackTrace();
    		return new Result(false, e.getMessage() , null);
    	}
    }
    
    /**
     * Computes prime number range for the specified limit and returns result as json.
     * On exception, Result object with failure flag and message set is returned.
     * Uses  @see example.strategy.ForkJoinAndOptimisedPrimeCheckPrimeRangeGenStrategy to compute the range 
     * @param maxNumber Limit
     * @return Result object
     */
    @RequestMapping("/findPrimeJoinFork")
    public Result computePrimesUsingJoinForkOptimisedPrimeCheckStrategy(@RequestParam(value="number") String maxNumber) 
    {
    	try
    	{
    		long limit = Validator.validateLimit(maxNumber);
    		long begin = System.currentTimeMillis();
    		List<Long> result = forkJoinOptPrimeCheckStrategy.getPrimeNumbers(limit);
    		System.out.println(String.format(LOG_FORMAT, "ForkJoinOptimisedPrimeCheck", (System.currentTimeMillis()-begin)/1000));
    		return new Result(true, null , result);
    	}
    	catch(Exception e)
    	{
    		//e.printStackTrace();
    		return new Result(false, e.getMessage() , null);
    	}
    }
    
    /**
     * Computes prime number range for the specified limit and returns result as json.
     * On exception, Result object with failure flag and message set is returned.
     * Uses  @see example.strategy.EulerSievePrimeRangeGenStrategy to compute the range 
     * @param maxNumber Limit
     * @return Result object
     */
    @RequestMapping("/findPrimeEuler")
    public Result computePrimesUsingEulerSieveStrategy(@RequestParam(value="number") String maxNumber) 
    {
    	try
    	{
    		long limit = Validator.validateLimit(maxNumber);
    		long begin = System.currentTimeMillis();
    		List<Long> result = eulerSievePrimeRangeGenStrategy.getPrimeNumbers(limit);
    		System.out.println(String.format(LOG_FORMAT, "EulerSieve", (System.currentTimeMillis()-begin)/1000));
    		return new Result(true, null , result);
    	}
    	catch(Exception e)
    	{
    		//e.printStackTrace();
    		return new Result(false, e.getMessage() , null);
    	}
    }
    
    
}
