package org.bambucha.math;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import static org.fest.assertions.Assertions.*;
import org.junit.Before;
import org.junit.Test;

public class PrimeSetTest
{
	private PrimeSet	test;

	@Before
	public void setUp() throws Exception
	{
		test = new PrimeSet();
	}

	@Test
	public void isTwoIsPrime()
	{
		assertThat(test.isPrime(2)).isTrue();
	}

	@Test
	public void isThreePrime() throws Exception
	{
		assertThat(test.isPrime(3)).isTrue();
	}

	@Test
	public void isThirtyOnePrime() throws Exception
	{
		assertThat(test.isPrime(31)).isTrue();
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneIsNotPrimeAndNotComplex() throws Exception
	{
		test.isPrime(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void zeroIsNotPrime() throws Exception
	{
		test.isPrime(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void isNegativePrime() throws Exception
	{
		test.isPrime(-1);
	}

	@Test
	public void testIterator()
	{
		test.isPrime(5);
		assertThat(test.iterator()).isNotNull();
	}

}
