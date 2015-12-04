package com.github.scompo.chooseforme.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.scompo.chooseforme.domain.AllStuff;
import com.github.scompo.chooseforme.domain.StuffToChoose;

@Controller
public class AddNewController {

	@Autowired
	private AllStuff allStuff;

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String saveNew(
			@Valid @ModelAttribute("newStuff") StuffToChoose newStuff, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			return "add-new";
		}

		if (allStuff.contains(newStuff)) {

			bindingResult.rejectValue("name", "error.name", "name already present");
			return "add-new";
		}

		allStuff.add(newStuff);

		return "redirect:/";
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String addNewPage(Model model) {

		model.addAttribute("newStuff", new StuffToChoose());

		return "add-new";
	}
}
