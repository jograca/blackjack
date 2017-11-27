package com.lmig.gfc.blackjack.models;

import java.util.Stack;

public class Player {

	private Stack<Card> hand;
	private double wallet;
	
	public Player (Stack<Card> hand, double wallet) {
		this.hand = hand;
		this.wallet = wallet; 
	}
	
	public void bet() {
		
	}
	
	public void hit() {
		
	}
	
	public void stay() {
		
	}
	
	public boolean playerIsBroke() {
		return wallet <= 0;
	}

	public Stack<Card> getHand() {
		return hand;
	}

	public double getWallet() {
		return wallet;
	}
	
}
