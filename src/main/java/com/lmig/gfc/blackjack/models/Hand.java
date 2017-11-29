package com.lmig.gfc.blackjack.models;

import java.util.Stack;

public class Hand {

	private Deck deck;
	private Stack<Card> hand;

	public Hand(int numberOfCards) {
		hand = new Stack<Card>();
	}

	public void newDealerHand(Card card1, Card card2) {
		deck.initialDealToDealer(card1, card2);
	}

	public void newPlayerHand(Card card1, Card card2) {
		deck.initialDealtoPlayer(card1, card2);
	}

	public void totalValue() {

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

	public Stack<Card> getHand() {
		return hand;
	}

	public void setHand(Stack<Card> hand) {
		this.hand = hand;
	}
}
