package com.example.ClienteRest.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	@RequestMapping(value = "/welcome")
	public String welcome(Model model){
		model.addAttribute("message", this.message);
		return "welcome";
	}

}
