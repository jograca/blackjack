package com.lmig.gfc.blackjack.models;

public class Game {

	private Deck deck;
	private Player player;
	private House house;

	public Game() {
		this.deck = deck;
		this.player = player;
		this.house = house;
	}

	public void initialDeal() {
		deck.initialDeal();
	}
}
