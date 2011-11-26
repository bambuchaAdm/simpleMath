package org.bambucha.math;

/**
 * Klasa reprezentujaca dzielnik liczby
 * 
 * @author bambucha
 * 
 */
public class Divisor
{
	private int	value;
	private int	times;

	/**
	 * Buduje dzielnik
	 * 
	 * @param value
	 *            wartość dzielnika
	 * @param times
	 *            krotność dzielnika
	 */
	public Divisor(int value, int times)
	{
		if(value < 1 || times < 1)
			throw new IllegalArgumentException(
					"Wartość i krotność muszą być dodatnie");
		this.times = times;
		this.value = value;
	}

	/**
	 * Zwraca wartość dzielnika
	 * 
	 * @return the value
	 */
	public Integer getValue()
	{
		return value;
	}

	/**
	 * Zwraca krotność dzielnika
	 * 
	 * @return the times
	 */
	public Integer getTimes()
	{
		return times;
	}

}
