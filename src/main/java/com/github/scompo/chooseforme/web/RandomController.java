package com.github.scompo.chooseforme.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.scompo.chooseforme.domain.AllStuff;
import com.github.scompo.chooseforme.domain.StuffToChoose;
import com.github.scompo.chooseforme.services.RandomService;

@Controller
public class RandomController {

	@Autowired
	private RandomService randomService;

	@Autowired
	private AllStuff allStuff;

	@RequestMapping(value = "random", method = RequestMethod.GET)
	public String getRandomPage(Model model) {

		StuffToChoose randomStuff = randomService.getRandom(allStuff);

		model.addAttribute("randomStuff", randomStuff);

		return "chosen";
	}

}
