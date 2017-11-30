package com.lmig.gfc.blackjack.models;

public class Player {

	private Hand hand;

	public Player() {
		hand = new Hand();
	}

	public void addToHand(Card card) {
		hand.addCardToHand(card);
	}

	public Hand getHand() {
		return hand;
	}

	public void newHand() {
		hand = new Hand();
	}

}
