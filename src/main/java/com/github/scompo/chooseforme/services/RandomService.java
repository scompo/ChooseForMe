package com.github.scompo.chooseforme.services;

import com.github.scompo.chooseforme.domain.StuffToChoose;
import com.github.scompo.chooseforme.domain.AllStuff;

public interface RandomService {

	StuffToChoose getRandom(AllStuff stuffs);

}
