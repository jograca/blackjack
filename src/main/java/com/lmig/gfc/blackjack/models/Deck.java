package com.lmig.gfc.blackjack.models;

import java.util.Stack;

public class Deck {

	private Stack<Card> availableCards;
	private Stack<Card> playerCards;
	private Stack<Card> dealerCards;

	public Deck() {
		availableCards = new Stack<Card>();
		playerCards = new Stack<Card>();
		dealerCards = new Stack<Card>();
	}
	
	public boolean deckIsEmpty() {
		return availableCards.isEmpty();
	}

	public Stack<Card> getAvailableCards() {
		return availableCards;
	}

	public Stack<Card> getPlayerCards() {
		return playerCards;
	}

	public Stack<Card> getDealerCards() {
		return dealerCards;
	}
	
}
