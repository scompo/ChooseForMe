package com.github.scompo.chooseforme.services;

import org.springframework.stereotype.Service;

import com.github.scompo.chooseforme.domain.StuffToChoose;
import com.github.scompo.chooseforme.domain.Stuffs;
import com.github.scompo.chooseforme.utils.RandomUtils;

@Service
public class RandomBusinessService implements RandomService {

	@Override
	public StuffToChoose getRandom(Stuffs stuffs) {

		StuffToChoose randomElement = null;

		Integer size = stuffs.size();

		Integer randomNumber = RandomUtils.getRandomNumber(size - 1);

		randomElement = stuffs.get(randomNumber);

		return randomElement;
	}

}