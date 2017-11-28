package com.lmig.gfc.blackjack.models;

import java.util.Stack;

public class Dealer {
	
	private Stack<Card> hand;
	
	public Dealer (Stack<Card> hand) {
		this.hand = hand;
	}
	
	public Stack<Card> getHand() {
		return hand;
	}
	
}
