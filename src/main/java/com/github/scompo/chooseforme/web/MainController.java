package com.github.scompo.chooseforme.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scompo.chooseforme.domain.AllStuff;
import com.github.scompo.chooseforme.domain.StuffToChoose;

@Controller
public class MainController {
	
	@Autowired
	private AllStuff allStuff;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		return "index";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "name") String name) {

		allStuff.remove(new StuffToChoose(name));

		return "redirect:/";
	}
	
	@RequestMapping(value = "deleteAll", method = RequestMethod.GET)
	public String deleteAll() {

		allStuff.clear();

		return "redirect:/";
	}
}
