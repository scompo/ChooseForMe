package com.github.scompo.chooseforme.services;

import com.github.scompo.chooseforme.domain.StuffToChoose;
import com.github.scompo.chooseforme.domain.Stuffs;

public interface RandomService {

	StuffToChoose getRandom(Stuffs stuffs);

}
