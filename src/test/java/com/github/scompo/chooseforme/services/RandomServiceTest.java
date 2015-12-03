package com.github.scompo.chooseforme.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.scompo.chooseforme.domain.StuffToChoose;
import com.github.scompo.chooseforme.domain.Stuffs;
import com.github.scompo.chooseforme.exceptions.EmptyListException;

public class RandomServiceTest {

	private static final Stuffs EMPTY_STUFFS = new Stuffs();

	private static final Stuffs NULL_STUFFS = null;

	private static final StuffToChoose ONLY_ELEMENT_STUFF_TO_CHOOSE = new StuffToChoose("ONLY ELEMENT");

	private static final Stuffs ONE_ELEMENT_STUFFS = new Stuffs(Arrays.asList(ONLY_ELEMENT_STUFF_TO_CHOOSE));

	private static final StuffToChoose STUFF_ONE = new StuffToChoose("ONE");

	private static final StuffToChoose STUFF_TWO = new StuffToChoose("TWO");

	private static final Stuffs MULTIPLE_ELEMENT_STUFFS = new Stuffs(Arrays.asList(STUFF_ONE, STUFF_TWO));

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

	@Test(expected = EmptyListException.class)
	public void testShouldReturnEmptyListExceptionIfStuffsIsEmpty() throws EmptyListException {

		randomService.getRandom(EMPTY_STUFFS);
	}

	@Test(expected = NullPointerException.class)
	public void testShouldReturnNullPointerExceptionIfStuffsIsNull() throws EmptyListException {

		randomService.getRandom(NULL_STUFFS);
	}

	@Test
	public void testShouldReturnTheOnlyElementIfStuffsHasOnlyOneElement() throws EmptyListException {

		assertEquals(ONLY_ELEMENT_STUFF_TO_CHOOSE, randomService.getRandom(ONE_ELEMENT_STUFFS));
	}

	@Test
	public void testShouldReturnARandomElementFromStuffs() throws EmptyListException {

		assertTrue(MULTIPLE_ELEMENT_STUFFS.contains(randomService.getRandom(MULTIPLE_ELEMENT_STUFFS)));
	}
}
