package com.github.scompo.chooseforme.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.scompo.chooseforme.domain.StuffToChoose;
import com.github.scompo.chooseforme.services.StuffToChooseService;

@Controller
public class PagesController {
	
	@Autowired
	private StuffToChooseService stuffToChooseService;
	
	@ModelAttribute(value = "allStuff")
	public List<StuffToChoose> populateStuffToChoose(){
		
		return stuffToChooseService.getAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(){
		
		return "index";
	}
	
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String saveNew(StuffToChoose stuffToChoose, Model model){
		
		return "redirect:/index";
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String newPage(Model model){
		
		return "add-new";
	}
}
