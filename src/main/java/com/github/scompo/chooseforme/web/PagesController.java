package com.github.scompo.chooseforme.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.scompo.chooseforme.domain.StuffToChoose;
import com.github.scompo.chooseforme.domain.Stuffs;
import com.github.scompo.chooseforme.exceptions.EmptyListException;
import com.github.scompo.chooseforme.services.RandomService;

@Controller
@SessionAttributes(names = { "allStuff" })
public class PagesController {

	private static final Logger logger = LoggerFactory.getLogger(PagesController.class);

	@Autowired
	private RandomService randomService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		if (!model.containsAttribute("allStuff")) {

			model.addAttribute("allStuff", new Stuffs());
		}

		return "index";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String saveNew(@ModelAttribute("newStuff") StuffToChoose newStuff, @ModelAttribute("allStuff") Stuffs stuffs) {

		stuffs.add(newStuff);

		return "redirect:/";
	}

	@RequestMapping(value = "random", method = RequestMethod.GET)
	public String getRandomPage(Model model, @ModelAttribute("allStuff") Stuffs stuffs) {

		model.addAllAttributes(getAttributesForRandom(stuffs));

		return "choosen";
	}

	private Map<String, ?> getAttributesForRandom(Stuffs stuffs) {

		Map<String, Object> attributes = new HashMap<String, Object>();

		Boolean error = false;
		String errorMessage = null;
		StuffToChoose randomStuff = null;

		try {

			randomStuff = getRandomStuffToChoose(stuffs);

			attributes.put("randomStuff", randomStuff);
		}
		catch (EmptyListException e) {

			error = true;
			errorMessage = e.getLocalizedMessage();

			logger.warn("ex: {}, {}", e.getClass().getSimpleName(), error);

			attributes.put("errorMessage", errorMessage);
		}

		attributes.put("isError", error);

		return attributes;
	}

	private StuffToChoose getRandomStuffToChoose(Stuffs stuffs) throws EmptyListException {

		return randomService.getRandom(stuffs);
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String newPage(Model model) {

		model.addAttribute("newStuff", new StuffToChoose());

		return "add-new";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "name") String name, @ModelAttribute("allStuff") Stuffs stuffs) {

		stuffs.remove(new StuffToChoose(name));

		return "redirect:/";
	}
}
