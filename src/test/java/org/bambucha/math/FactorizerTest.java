package org.bambucha.math;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
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

	@Test
	public void dustributeTwo()
	{
		List<Divisor> list = Arrays
				.asList(new Divisor(1, 1), new Divisor(2, 1));
		assertThat(test.distribute(2)).isIn(list);
	}

	@Test
	public void distibuteMustHaveOneAtStart()
	{
		assertThat(test.distribute(2)).contains(new Divisor(1, 1));
		assertThat(test.distribute(3)).contains(new Divisor(1, 1));
		assertThat(test.distribute(4)).contains(new Divisor(1, 1));
		assertThat(test.distribute(5)).contains(new Divisor(1, 1));
	}

	@Test
	public void complex() throws Exception
	{
		List<Divisor> list = Arrays
				.asList(new Divisor(1, 1), new Divisor(2, 2));
		assertThat(test.distribute(4)).isIn(list);
	}
}
