package com.lmig.gfc.blackjack.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjack.models.Card;
import com.lmig.gfc.blackjack.models.Deck;
import com.lmig.gfc.blackjack.models.Hand;

@Controller
public class BlackjackController {

	// private Game game;
	//
	// public public TwentyOneController() {
	// game = new Game();
	// }

	private Stack<Card> cards;

	private ModelAndView redirectToHome() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	@GetMapping("/")
	public ModelAndView showBetScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bet");
		return mv;
	}

	@PostMapping("/bet")
	public ModelAndView handleBet(int bet) {
		// game.makePlayerBet(bet);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/play");
		return mv;
	}

	@GetMapping("/play")
	public ModelAndView showPlayScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");

		// mv.addObject("playerHand", game.getPlayerHand());

		Deck deck = new Deck();
		deck.shuffle();

		Hand hand = new Hand();
		hand.getHand();

		mv.addObject("deck", deck);
		mv.addObject("hand", hand);
		mv.addObject("card");

		return mv;
	}

}