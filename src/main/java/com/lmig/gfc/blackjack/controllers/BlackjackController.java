package com.lmig.gfc.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjack.models.Deck;
import com.lmig.gfc.blackjack.models.Game;
import com.lmig.gfc.blackjack.models.Hand;

@Controller
public class BlackjackController {

	private Game game;
	private Deck deck;
	private Hand hand;

	public BlackjackController() {
		this.game = new Game();
		this.deck = new Deck();
		this.hand = new Hand();
	}

	@GetMapping("/")
	public ModelAndView showBetScreen() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("bet");
		return mv;
	}

	@PostMapping("/bet")
	public ModelAndView handleBet(int bet) {

		game.deal();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/play");
		return mv;
	}

	@GetMapping("/play")
	public ModelAndView showPlayScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");

		hand.getHand();
		game.findWinner();

		// mv.addObject("playerHand", game.getPlayerHand());

		mv.addObject("deck", deck);
		mv.addObject("hand", hand);
		mv.addObject("game", game);

		return mv;
	}

	// Hit
	// Tells blackjack it wants a card
	@PostMapping("/hit")
	public ModelAndView takeACard() {

		game.hit();
		game.findWinner();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/play");

		return mv;
	}

	// Hit
	// Tells blackjack it wants a card
	@PostMapping("/stay")
	public ModelAndView playerStays() {

		game.stay();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/play");

		return mv;
	}
}