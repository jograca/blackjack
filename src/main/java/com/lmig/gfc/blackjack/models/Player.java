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

	public boolean isBusted() {
		return hand.isBust();
	}

	public boolean hasBlackjack() {
		return hand.isBlackjack();
	}

	public void makeNewHand() {
		hand = new Hand();
	}

}
