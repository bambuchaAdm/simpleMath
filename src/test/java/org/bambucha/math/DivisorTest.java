package org.bambucha.math;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class DivisorTest
{
	Divisor	test;

	@Before
	public void setUp() throws Exception
	{
		test = new Divisor(1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeTimes()
	{
		new Divisor(2, -2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeValueInConstructor() throws Exception
	{
		new Divisor(-1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void zeroTimesInConstrutor() throws Exception
	{
		new Divisor(1, 0);
	}

	@Test
	public void testGetValue()
	{
		assertThat(test.getValue()).isEqualTo(1);
	}

	@Test
	public void testGetTimes()
	{
		assertThat(test.getTimes()).isEqualTo(1);
	}

}
