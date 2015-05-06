package br.com.starcode.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.starcode.finance.service.MovementService;

@Controller
public class MovementController {
	
	@Autowired MovementService movementService;

	@RequestMapping("/movement")
	ModelAndView buscarEntradas() {
		
		return new ModelAndView("");
		
	}
	
	
}
