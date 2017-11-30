package com.lmig.gfc.blackjack.models;

import java.util.LinkedList;

public class Hand {

	private LinkedList<Card> hand;

	private int handTotal;
	private boolean isBlackjack;
	private boolean isBust;
	private boolean canHit;

	public Hand() {
		hand = new LinkedList<Card>();
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

	public LinkedList<Card> getHand() {
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