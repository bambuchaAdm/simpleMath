package org.bambucha.math;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Iterator;

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
	public void zeroIsNotPrimeAndNotComplex() throws Exception
	{
		test.isPrime(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeIsNotSupportedPrime() throws Exception
	{
		test.isPrime(-1);
	}

	@Test
	public void getIterator()
	{
		test.isPrime(5);
		assertThat(test.iterator()).isNotNull().hasSize(3)
				.doesNotHaveDuplicates();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void immutableCollecitonUnderIterator() throws Exception
	{
		// given
		test.isPrime(5);
		Iterator<Long> iter = test.iterator();
		// when
		iter.next();
		// then
		iter.remove();
	}
}
