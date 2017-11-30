package com.lmig.gfc.blackjack.models;

import java.util.Stack;

public class Hand {

	private Stack<Card> hand;

	private int handTotal;
	private boolean isBlackjack;
	private boolean isBust;
	private boolean canHit;

	public Hand() {
		hand = new Stack<Card>();
	}

	public boolean canHit() {
		return (handTotal < 21);
	}

	public void addCardToHand(Card card) {

		this.hand.add(card);
		this.handTotal += card.getValue();

		while (!canHit) {
			handTotal -= 10;
		}

		if (canHit) {
			isBust = true;
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

}