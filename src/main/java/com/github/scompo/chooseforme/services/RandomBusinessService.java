package com.github.scompo.chooseforme.services;

import org.springframework.stereotype.Service;

import com.github.scompo.chooseforme.domain.StuffToChoose;
import com.github.scompo.chooseforme.domain.AllStuff;
import com.github.scompo.chooseforme.utils.RandomUtils;

@Service
public class RandomBusinessService implements RandomService {

	@Override
	public StuffToChoose getRandom(AllStuff stuffs) {

		StuffToChoose randomElement = null;

		if (stuffs == null || stuffs.isEmpty()) {

			randomElement = StuffToChoose.NOT_PRESENT;

		}
		else {

			randomElement = stuffs.get(RandomUtils.getRandomNumber(stuffs.size() - 1));
		}

		return randomElement;
	}

}