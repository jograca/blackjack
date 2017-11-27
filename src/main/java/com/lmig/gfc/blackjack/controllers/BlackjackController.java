package com.lmig.gfc.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlackjackController {

	// TODO Private Variables
	
	public BlackjackController() {
		// TODO Auto-generated constructor stub
	}

	
	// Method to return a redirect back to home
	private ModelAndView redirectToHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	// GetMapping for the home page (game.html)
	@GetMapping ("/")
	public ModelAndView setupGame() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("game");
		return mv;
	}
	
	@PostMapping("/deal")
	public ModelAndView dealCards() {
		//Deal deal = new Deal();
		
		return redirectToHome();
	}
}
