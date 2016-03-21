package com.example.strategy;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.example.strategy.ForkJoinAndOptimisedPrimeCheckPrimeRangeGenStrategy;

public class ForkJoinAndOptimisedPrimeCheckPrimeRangeGenStrategyTest {

	@Test
	public void test() {
		ForkJoinAndOptimisedPrimeCheckPrimeRangeGenStrategy strategy = new ForkJoinAndOptimisedPrimeCheckPrimeRangeGenStrategy();
		List<Long> result = strategy.getPrimeNumbers(20);
		assertEquals(Arrays.asList(2l,3l,5l,7l,11l,13l,17l,19l), result);
	}

}
