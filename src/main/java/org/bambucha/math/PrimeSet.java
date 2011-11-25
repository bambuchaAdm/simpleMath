/**
 * 
 */
package org.bambucha.math;

import static java.util.Collections.unmodifiableCollection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Klasa testuje pierwszość liczby
 * 
 * @author bambucha
 */
public class PrimeSet implements Iterable<Long>
{
	private Collection<Long>	primes;

	/**
	 * Standardowy konstruktor
	 */
	public PrimeSet()
	{
		primes = new HashSet<Long>();
	}

	/**
	 * Zwraca odpowiedź na pytanie czy argument jest pierwszy
	 * 
	 * @param toTest
	 * @return
	 */
	public boolean isPrime(long toTest)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<Long> iterator()
	{
		return unmodifiableCollection(primes).iterator();
	}
}
