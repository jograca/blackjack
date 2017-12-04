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

	public Card getHandPositionOne() {
		return hand.getHand().get(0);
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
