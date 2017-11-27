package com.lmig.gfc.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjack.models.Deck;

@Controller
public class BlackjackController {

	// Private Variables
	private Deck deck;

	// Constructor
	public BlackjackController() {
		this.deck = new Deck();
	}

	// Method to return a redirect back to home
	private ModelAndView redirectToHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	// GetMapping for the home page (game.html)
	@GetMapping("/")
	public ModelAndView setupGame() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("game");
		mv.addObject("deck", deck);
		
		return mv;
	}

	@PostMapping("/deal")
	public ModelAndView dealCards() {
		
		deck.setupDeck();
		deck.shuffle();
		deck.initialDeal();
		
		return redirectToHome();
	}
	
	@PostMapping("/hit")
	public ModelAndView takeACard() {
		
		deck.hit();
		
		return redirectToHome();
	}
}
