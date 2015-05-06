package br.com.starcode.finance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	String home() {
		return "home";
	}
	
	@RequestMapping("/about")
	String sobre() {
		return "about";
	}
	
}




