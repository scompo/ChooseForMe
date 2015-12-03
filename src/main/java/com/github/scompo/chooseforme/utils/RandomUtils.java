package com.github.scompo.chooseforme.utils;

import java.util.Random;

public class RandomUtils {

	public static final Integer ZERO = 0;

	/**
	 * Returns a random number between 0 and max (inclusive).
	 * 
	 * @param max max number for random.
	 * 
	 * @return a random number between 0 and max (inclusive).
	 */
	public static Integer getRandomNumber(Integer max) {

		int randomResult = 0;

		if (!max.equals(ZERO)) {

			Random random = new Random();
			randomResult = random.nextInt(max + 1);
		}

		return randomResult;
	}

}
