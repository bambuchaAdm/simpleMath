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

	@Test
	public void equalIsSymetric() throws Exception
	{

		Divisor two = new Divisor(1, 1);
		Divisor three = new Divisor(2, 2);
		assertThat(two.equals(test)).isEqualTo(test.equals(two));
		assertThat(three.equals(test)).isEqualTo(test.equals(three));
	}

	@Test
	public void equalsIsReflexible() throws Exception
	{
		assertThat(test.equals(test)).isTrue();
	}

	@Test
	public void equalsIsTransitive() throws Exception
	{
		Divisor two = new Divisor(1, 1);
		Divisor three = new Divisor(1, 1);
		assertThat(test.equals(three)).isEqualTo(
				test.equals(two) && two.equals(three));
	}

	@Test
	public void secondTestFortRasitive() throws Exception
	{
		Divisor two = new Divisor(1, 1);
		Divisor three = new Divisor(2, 1);
		assertThat(test.equals(three)).isEqualTo(
				test.equals(two) && two.equals(three));
	}

	@Test
	public void notEqualasForNull() throws Exception
	{
		assertThat(test.equals(null)).isFalse();
	}
}
