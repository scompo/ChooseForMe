package com.github.scompo.chooseforme.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.scompo.chooseforme.domain.AllStuff;
import com.github.scompo.chooseforme.domain.StuffToChoose;

public class RandomServiceTest {

	private static final AllStuff NULL_STUFFS = null;

	private static final StuffToChoose ONLY_ELEMENT_STUFF_TO_CHOOSE = new StuffToChoose("ONLY ELEMENT");

	private static final AllStuff ONE_ELEMENT_STUFFS = new AllStuff(Arrays.asList(ONLY_ELEMENT_STUFF_TO_CHOOSE));

	private static final StuffToChoose STUFF_ONE = new StuffToChoose("ONE");

	private static final StuffToChoose STUFF_TWO = new StuffToChoose("TWO");

	private static final AllStuff MULTIPLE_ELEMENT_STUFFS = new AllStuff(Arrays.asList(STUFF_ONE, STUFF_TWO));

	private RandomService randomService;

	@Before
	public void setUp() {

		randomService = createRandomService();
	}

	public RandomService createRandomService() {

		return new RandomBusinessService();
	}

	@After
	public void tearDown() {

		randomService = null;
	}

	public void testShouldReturnNotPresentIfStuffsIsNull() {

		assertEquals(StuffToChoose.NOT_PRESENT, randomService.getRandom(NULL_STUFFS));
	}

	@Test
	public void testShouldReturnTheOnlyElementIfStuffsHasOnlyOneElement() {

		assertEquals(ONLY_ELEMENT_STUFF_TO_CHOOSE, randomService.getRandom(ONE_ELEMENT_STUFFS));
	}

	@Test
	public void testShouldReturnARandomElementFromStuffs() {

		assertTrue(MULTIPLE_ELEMENT_STUFFS.contains(randomService.getRandom(MULTIPLE_ELEMENT_STUFFS)));
	}
}
