package com.lmig.gfc.blackjack.models;

public class Game {

	private Deck deck;
	private Player player;
	private House house;

	private boolean playerWins;
	private boolean houseWins;
	private boolean gamePush;

	// Constructor
	public Game() {
		this.deck = new Deck();
		this.player = new Player();
		this.house = new House();
	}

	// boolean to hold a place for the game ending
	public boolean gameOver() {
		return gameOver();
	}

	// Deal out the initial 2 cards
	// called at the beginning of the game
	public void deal() {

		player.addToHand(deck.pullCardFromDeck());
		player.addToHand(deck.pullCardFromDeck());
		house.addToHand(deck.pullCardFromDeck());
		house.addToHand(deck.pullCardFromDeck());

	}

	// public void findWinner() {
	// boolean playerBusted = getPlayerHand().isBust();
	// boolean dealerBusted = getHouseHand().isBust();
	// boolean playerBlackjack = getPlayerHand().isBlackjack();
	// boolean dealerBlackjack = getHouseHand().isBlackjack();
	//
	// if (playerBusted) {
	// // player lost
	// houseWins = true;
	// // game ends
	// gameOver();
	// } else if (dealerBusted) {
	// // dealer busted
	// // player wins
	// playerWins = true;
	// // money added to wallet
	// addWinningsToWallet();
	// // game ends
	// gameOver();
	// } else if (playerBlackjack) {
	// // player wins
	// playerWins = true;
	// // money added to wallet
	// addWinningsToWallet();
	// // game ends
	// gameOver();
	// } else if (dealerBlackjack) {
	// // dealer wins
	// houseWins = true;
	// // game ends
	// gameOver();
	// } else if (playerBlackjack && dealerBlackjack) {
	// // push (neither wins)
	// gamePush = true;
	// // money on bet returned
	// addWinningsToWallet();
	// // game ends
	// gameOver();
	// }
	// }
	//
	//// private void addWinningsToWallet() {
	//// if (push) {
	//// setWalletAmount(bet);
	//// } else if (getPlayerHand().isBlackjack()) {
	//// setWalletAmount((bet * 1.5) + bet);
	//// } else {
	//// setWalletAmount(bet * 2);
	//// }
	//// }

	public void hit() {

		if (player.getHand().getHandTotal() <= 21) {
			player.addToHand(deck.pullCardFromDeck());
		}
	}

	public void stay() {

		while (house.getHand().getHandTotal() < 17) {
			house.addToHand(deck.pullCardFromDeck());
		}
	}

	public Hand getPlayerHand() {
		return player.getHand();
	}

	public Hand getHouseHand() {
		return house.getHand();
	}

	public int getPlayerTotal() {
		return player.getHand().getHandTotal();
	}

	public int getHouseTotal() {
		return house.getHand().getHandTotal();
	}

}
