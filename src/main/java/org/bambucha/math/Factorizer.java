/**
 * 
 */
package org.bambucha.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa rozkładająca liczby na ich czyniki pierwsze
 * 
 * @author bambucha
 * 
 */
public class Factorizer
{
	private PrimeSet	primes;

	/**
	 * Standardowy konsturktor
	 */
	public Factorizer()
	{
		primes = new PrimeSet();
	}

	private List<Divisor> getDivisorListPrototype()
	{
		List<Divisor> divisors = new ArrayList<Divisor>();
		divisors.add(new Divisor(1, 1));
		return divisors;
	}

	private boolean isDivisor(long number, long base)
	{
		return number % base == 0;
	}

	private int times(long number, long base)
	{
		int times = 0;
		while(isDivisor(number, base))
		{
			number /= base;
			++times;
		}
		return times;
	}

	/**
	 * Rozkłada liczbę na czyniki pierwsze
	 * 
	 * @param number
	 *            liczba
	 * @return lista czyników pierwszych
	 */
	public List<Divisor> distribute(long number)
	{
		List<Divisor> divisors = getDivisorListPrototype();
		if(primes.isPrime(number))
		{
			divisors.add(new Divisor(number, 1));
			return divisors;
		}
		for(Long prime : primes)
		{
			if(prime > number)
				break;
			if(isDivisor(number, prime.longValue()))
				divisors.add(new Divisor(prime, times(number, prime.longValue())));
		}
		return divisors;

	}
}
