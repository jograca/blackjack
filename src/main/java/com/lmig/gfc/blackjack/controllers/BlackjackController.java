package com.lmig.gfc.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjack.models.AceCard;
import com.lmig.gfc.blackjack.models.Deck;
import com.lmig.gfc.blackjack.models.Hand;
import com.lmig.gfc.blackjack.models.NumberCard;
import com.lmig.gfc.blackjack.models.Suits;

@Controller
public class BlackjackController {

	// private Game game;
	//
	// public public TwentyOneController() {
	// game = new Game();
	// }

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
		deck.initializeDeck();

		Hand hand = new Hand();
		hand.accept(new AceCard(Suits.DIAMONDS));
		hand.accept(new NumberCard(Suits.CLUBS, 4));
		hand.accept(new NumberCard(Suits.HEARTS, 8));

		mv.addObject("hand", hand);

		return mv;
	}

}