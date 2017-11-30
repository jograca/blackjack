package com.lmig.gfc.blackjack.models;

public class House {

	private Hand hand;

	public House() {
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
