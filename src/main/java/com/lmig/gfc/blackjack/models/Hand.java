package com.lmig.gfc.blackjack.models;

import java.util.LinkedList;
import java.util.List;

public class Hand {

	private Deck deck;
	private LinkedList<Card> cards;

	public Hand() {
		cards = new LinkedList<Card>();
	}

	public void getFromDeck() {
		deck.initializeDeck();

	}

	public void accept(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return cards;
	}

	public int getTotal() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getValue();
		}
		return sum;
	}

	public boolean isBlackjack() {
		return true;
	}

	public boolean isBust() {
		return true;
	}

	public boolean canHit() {
		return true;
	}

}
