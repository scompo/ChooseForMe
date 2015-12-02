package com.github.scompo.chooseforme.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.scompo.chooseforme.domain.StuffToChoose;

@Service
public class StuffToChooseBusinessService implements StuffToChooseService {

	private static final StuffToChoose STUFF_DEFAULT = new StuffToChoose("default");

	@Override
	public List<StuffToChoose> getAll() {
		
		List<StuffToChoose> list = new ArrayList<StuffToChoose>();
		
		list.add(STUFF_DEFAULT);
		
		return list;
	}

}
