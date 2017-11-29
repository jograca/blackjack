package com.lmig.gfc.blackjack.models;

public class Card {

	private String suit;
	private int value;
	private String rank;

	public Card(String suit, int value, String rank) {
		this.suit = suit;
		this.value = value;
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public String getRank() {
		return rank;
	}

}
