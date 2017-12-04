package com.lmig.gfc.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjack.models.Deck;
import com.lmig.gfc.blackjack.models.Game;
import com.lmig.gfc.blackjack.models.Hand;
import com.lmig.gfc.blackjack.models.Wallet;

@Controller
public class BlackjackController {

	private Game game;
	private Deck deck;
	private Hand hand;
	private Wallet wallet;

	public BlackjackController() {
		this.game = new Game();
		this.deck = new Deck();
		this.hand = new Hand();
		this.wallet = new Wallet();
	}

	public ModelAndView redirectToPlay() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/play");

		return mv;
	}

	@GetMapping("/")
	public ModelAndView showBetScreen() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("bet");

		return mv;
	}

	@PostMapping("/bet")
	public ModelAndView handleBet(Double bet) {

		game.resetWallet();
		game.makePlayerBet(bet);
		game.deal();

		return redirectToPlay();
	}

	@GetMapping("/play")
	public ModelAndView showPlayScreen() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");

		hand.getHand();

		mv.addObject("deck", deck);
		mv.addObject("hand", hand);
		mv.addObject("game", game);
		mv.addObject("wallet", wallet);

		return mv;
	}

	// Hit
	// Tells blackjack it wants a card
	@PostMapping("/hit")
	public ModelAndView takeACard() {

		game.hit();

		return redirectToPlay();
	}

	// Hit
	// Tells blackjack it wants a card
	@PostMapping("/stay")
	public ModelAndView playerStays(Double money) {

		game.stay();
		// game.payout(money);

		return redirectToPlay();
	}

	@PostMapping("/newgame")
	public ModelAndView startNewGame() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}

}