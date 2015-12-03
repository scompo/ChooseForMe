package com.github.scompo.chooseforme.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.scompo.chooseforme.domain.StuffToChoose;
import com.github.scompo.chooseforme.domain.Stuffs;

@Controller
@SessionAttributes(names = { "allStuff" })
public class PagesController {

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
