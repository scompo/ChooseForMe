package com.github.scompo.chooseforme.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RandomUtilsTest {

	private static final Integer MAX = 100;

	private static final Integer NULL_NUM = null;

	@Test
	public void testGetRandomNumberOfZeroShouldBeZero() {

		assertEquals(RandomUtils.ZERO, RandomUtils.getRandomNumber(RandomUtils.ZERO));
	}

	@Test
	public void testGetRandomNumberIsCorrect() {

		Integer res = RandomUtils.getRandomNumber(MAX);

		assertTrue("Should be equals or bigger than zero", res.compareTo(RandomUtils.ZERO) >= 0);
		assertTrue("Should be equals or less than max", res.compareTo(MAX) <= 0);
	}

	@Test(expected = NullPointerException.class)
	public void testShouldReturnNullPointerExceptionIfMaxIsNull() {

		RandomUtils.getRandomNumber(NULL_NUM);
	}

}
