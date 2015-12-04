package com.github.scompo.chooseforme.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.scompo.chooseforme.domain.StuffToChoose;
import com.github.scompo.chooseforme.domain.Stuffs;
import com.github.scompo.chooseforme.services.RandomService;

@Controller
@SessionAttributes(names = { "allStuff" })
public class PagesController {

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
	public String saveNew(Model model, @ModelAttribute("allStuff") Stuffs stuffs,
			@Valid @ModelAttribute("newStuff") StuffToChoose newStuff, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			return "add-new";
		}

		if (stuffs.contains(newStuff)) {

			bindingResult.rejectValue("name", "error.name", "name already present");
			return "add-new";
		}

		stuffs.add(newStuff);

		return "redirect:/";
	}

	@RequestMapping(value = "random", method = RequestMethod.GET)
	public String getRandomPage(Model model, @ModelAttribute("allStuff") Stuffs stuffs, BindingResult bindingResult) {

		if (stuffs == null || stuffs.isEmpty()) {

			bindingResult.reject("errors.allStuff", "list is empty");
			return "chosen";
		}

		StuffToChoose randomStuff = getRandomStuffToChoose(stuffs);

		model.addAttribute("randomStuff", randomStuff);

		return "chosen";
	}

	private StuffToChoose getRandomStuffToChoose(Stuffs stuffs) {

		return randomService.getRandom(stuffs);
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String addNewPage(Model model) {

		model.addAttribute("newStuff", new StuffToChoose());

		return "add-new";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "name") String name, @ModelAttribute("allStuff") Stuffs stuffs) {

		stuffs.remove(new StuffToChoose(name));

		return "redirect:/";
	}
}
