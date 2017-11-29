package com.lmig.gfc.blackjack.models;

public class Player {

	private Hand hand;
	private double wallet;

	public Player(Hand hand, double wallet) {
		this.hand = hand;
		this.wallet = wallet;
	}

	public boolean playerIsBroke() {
		return wallet <= 0;
	}

	public double getWallet() {
		return wallet;
	}

	public Hand getHand() {
		return hand;
	}

}
