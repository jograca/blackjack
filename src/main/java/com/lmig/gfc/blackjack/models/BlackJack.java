package com.lmig.gfc.blackjack.models;

import java.util.Collections;
import java.util.Stack;

public class BlackJack {

	private Stack<Card> availableCards;
	private Stack<Card> playerCards;
	private Stack<Card> dealerCards;

	private int playerTotal;
	
	// Don't get rid of this! Used by mustache in your view
	private int dealerTotal;

	public BlackJack() {
		availableCards = new Stack<Card>();
		playerCards = new Stack<Card>();
		dealerCards = new Stack<Card>();
	}

	public boolean gameOn() {
		return (!availableCards.isEmpty());
	}
	
	public void startGame() {
		this.setupDeck();
		this.shuffle();
		this.initialDeal();
	}

	public void setupDeck() {
		for (int i = 1; i <= 10; i++) {

			Card spades = new Card("Spades", i);
			Card diamonds = new Card("Diamonds", i);
			Card hearts = new Card("Hearts", i);
			Card clubs = new Card("Clubs", i);

			availableCards.push(spades);
			availableCards.push(diamonds);
			availableCards.push(hearts);
			availableCards.push(clubs);
		}
	}

	public void shuffle() {
		Collections.shuffle(availableCards);
	}

	public void initialDeal() {
		Card playerCard1 = availableCards.pop();
		Card playerCard2 = availableCards.pop();

		Card dealerCard1 = availableCards.pop();
		Card dealerCard2 = availableCards.pop();

		playerCards.push(playerCard1);
		playerCards.push(playerCard2);

		dealerCards.push(dealerCard1);
		dealerCards.push(dealerCard2);

		playerTotal = playerCard1.getValue() + playerCard2.getValue();
		dealerTotal = dealerCard1.getValue() + dealerCard2.getValue();

	}

	public void hit() {

		System.out.println("Player Total: " + playerTotal);

		if (playerTotal <= 21) {
			Card playerCard = availableCards.pop();
			playerTotal = playerTotal + playerCard.getValue();
			playerCards.push(playerCard);
		}
	}
	
	public void stay() {
		
	}
}
