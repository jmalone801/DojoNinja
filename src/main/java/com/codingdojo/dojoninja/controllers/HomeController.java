package com.codingdojo.dojoninja.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.codingdojo.dojoninja.models.Dojo;
import com.codingdojo.dojoninja.models.Ninja;
import com.codingdojo.dojoninja.services.MainService;

@Controller
public class HomeController {

	@Autowired
	MainService mainService;
	
	@RequestMapping("/dojos/new")
	public String DojoForm(Model model, @ModelAttribute("dojos") Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@PostMapping("/newdojo")
	public String createDojo(@Valid @ModelAttribute("dojos") Dojo dojo, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "newdojo.jsp";
		} else {
			mainService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping("/ninjas/new")
	public String ninjaForm(Model model, @ModelAttribute("ninjas") Ninja ninja) {
		model.addAttribute("dojos", mainService.allDojos());
		return "newninja.jsp";
	}
	
	
	@PostMapping("/newninja")
	public String createNinja(Model model, @Valid @ModelAttribute("ninjas") Ninja ninja, 
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", mainService.allDojos());
			return "newninja.jsp";
		} else {
			mainService.createNinja(ninja);
			Dojo dojo = ninja.getDojo();
			Long id = dojo.getId();
			return "redirect:/dojos/" + id;
		}	
	}
	
	@RequestMapping("/dojos/{id}")
	public String DojosNinjas(Model model, @PathVariable Long id) {
		Dojo dojo = mainService.findDojoById(id);
		model.addAttribute("dojo", dojo);
		return "dojoninjas.jsp";
	}
	
	
}
