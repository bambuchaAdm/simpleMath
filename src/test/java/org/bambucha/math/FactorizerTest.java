package org.bambucha.math;

import static org.fest.assertions.Assertions.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FactorizerTest
{
	Factorizer	test;

	@Before
	public void setUp() throws Exception
	{
		test = new Factorizer();
	}

	private boolean comp(List<Divisor> one, List<Divisor> two)
	{
		Iterator<Divisor> i = one.iterator();
		Iterator<Divisor> j = two.iterator();
		while(i.hasNext() && j.hasNext())
			if(!i.next().equals(j.next()))
				return false;
		return true;
	}

	@Test
	public void dustributeTwo()
	{
		List<Divisor> list = Arrays
				.asList(new Divisor(1, 1), new Divisor(2, 1));
		assertThat(comp(test.distribute(2), list)).isTrue();
	}

	@Test
	public void distibuteMustHaveOneAtStart()
	{
		List<Divisor> one = Arrays.asList(new Divisor(1, 1));
		assertThat(comp(test.distribute(2), one)).isTrue();
		assertThat(comp(test.distribute(4), one)).isTrue();
	}

	@Test
	public void complex() throws Exception
	{
		List<Divisor> list = Arrays
				.asList(new Divisor(1, 1), new Divisor(2, 2));
		assertThat(comp(test.distribute(4), list)).isTrue();
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneIsNotSupported() throws Exception
	{
		test.distribute(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void zeroIsNotSupported() throws Exception
	{
		test.distribute(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeIsNotSupported() throws Exception
	{
		test.distribute(-1);
	}
}
