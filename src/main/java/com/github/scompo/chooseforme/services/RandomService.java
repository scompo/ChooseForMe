package com.github.scompo.chooseforme.services;

import com.github.scompo.chooseforme.domain.StuffToChoose;
import com.github.scompo.chooseforme.domain.Stuffs;
import com.github.scompo.chooseforme.exceptions.EmptyListException;

public interface RandomService {

	StuffToChoose getRandom(Stuffs stuffs) throws EmptyListException;

}
