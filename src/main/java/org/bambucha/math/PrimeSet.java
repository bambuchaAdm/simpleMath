/**
 * 
 */
package org.bambucha.math;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static java.util.Collections.unmodifiableCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Klasa testuje pierwszość liczby
 * 
 * @author bambucha
 */
public class PrimeSet implements Iterable<Long>
{
	private List<Long>	primes;

	/**
	 * Standardowy konstruktor
	 */
	public PrimeSet()
	{
		primes = new ArrayList<Long>();
		primes.add(2L);
	}

	/**
	 * Naiwnie sprawdza czy liczba jest pierwsza
	 * 
	 * @param test
	 *            licza do testu
	 * @return <code>true<code> jeśli jest pierwsza
	 */
	private boolean checkPrime(long test)
	{
		for(Long prime : primes)
		{
			if(prime * prime > test)
				return true;
			if(test % prime == 0)
				return false;
		}
		throw new RuntimeException("Prawdopodobnie nie powinno się wydarzyć");
	}

	/**
	 * @return ostatnia liczba pierwsza
	 */
	private long last()
	{
		return primes.get(primes.size() - 1);
	}

	private void resize(long value)
	{
		long current = last() + 1;
		do
		{
			if(checkPrime(current))
				primes.add(current);
			current++;
		}
		while(current * current < value);

		while(!checkPrime(current++))
		{}
		primes.add(current);
	}

	/**
	 * Zwraca odpowiedź na pytanie czy argument jest pierwszy
	 * 
	 * @param toTest
	 * @return
	 */
	public boolean isPrime(long toTest)
	{
		if(toTest < 2)
			throw new IllegalArgumentException("Pierwsza musi być >=2");
		if(primes.get(primes.size() - 1) > floor(sqrt(toTest)))
			return checkPrime(toTest);
		resize(toTest);
		return checkPrime(toTest);
	}

	@Override
	public Iterator<Long> iterator()
	{
		return unmodifiableCollection(primes).iterator();
	}
}
