package com.jgalano.stratpoint.controller;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {	
	
	@GetMapping({"/", "/welcome"})
	public String welcome(Model model, HttpSession session) {
		model.addAttribute("userDetails", session.getAttribute("userDetails"));
		model.addAttribute("pageTitle", "Home");
		return "welcome";
	}
	
	
}
