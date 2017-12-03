package com.lmig.gfc.blackjack.models;

import java.util.Stack;

public class Hand {

	private Stack<Card> hand;

	private int handTotal;
	private boolean isBlackjack;
	private boolean isBust;
	private int aces;

	public Hand() {
		hand = new Stack<Card>();
	}

	public void addCardToHand(Card card) {

		hand.add(card);
		handTotal += card.getValue();

		if (card.getValue() == 11) {
			aces += 1;
		}

		while (handTotal > 21 && aces > 0) {
			handTotal -= 10;
			aces -= 1;
		}

	}

	public Stack<Card> getHand() {
		return hand;
	}

	public int getHandTotal() {
		return handTotal;
	}

	public boolean isBlackjack() {
		return isBlackjack;
	}

	public boolean isBust() {
		return isBust;
	}

	public int getHandSize() {
		return hand.size();
	}

}