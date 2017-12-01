package com.lmig.gfc.blackjack.models;

public class Game {

	private Deck deck;
	private Player player;
	private House house;

	private boolean playerWins = false;
	private boolean houseWins = false;
	private boolean gamePush = false;
	private boolean playerBlackjack = false;
	private boolean houseBlackjack = false;
	private boolean gameOver = false;

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

		player.makeNewHand();
		house.makeNewHand();

		player.addToHand(deck.pullCardFromDeck());
		player.addToHand(deck.pullCardFromDeck());
		house.addToHand(deck.pullCardFromDeck());
		house.addToHand(deck.pullCardFromDeck());

	}

	public void findWinner() {

		if (house.getHand().getHandTotal() > 21) {

			playerWins = true;
			gameOver = true;
		}
		// Player Busted
		if (player.getHand().getHandTotal() > 21) {

			houseWins = true;
			gameOver = true;
		}
		if (player.getHand().getHandTotal() == 21 && player.getHand().getHandSize() == 2) {

			playerWins = true;
			playerBlackjack = true;
			gameOver = true;
		}
		if (house.getHand().getHandTotal() == 21 && house.getHand().getHandSize() == 2) {

			houseWins = true;
			houseBlackjack = true;
			gameOver = true;
		}
		if ((house.getHand().getHandTotal() == 21) && (player.getHand().getHandTotal() == 21)
				&& (house.getHand().getHandSize() == 2) && (player.getHand().getHandSize() == 2)) {
			gamePush = true;
			playerBlackjack = true;
			houseBlackjack = true;
			gameOver = true;
		}
	}

	// private void addWinningsToWallet() {
	// if (push) {
	// setWalletAmount(bet);
	// } else if (getPlayerHand().isBlackjack()) {
	// setWalletAmount((bet * 1.5) + bet);
	// } else {
	// setWalletAmount(bet * 2);
	// }
	// }

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

	public boolean isPlayerWins() {
		return playerWins;
	}

	public boolean isHouseWins() {
		return houseWins;
	}

	public boolean isGamePush() {
		return gamePush;
	}

	public boolean isPlayerBlackjack() {
		return playerBlackjack;
	}

	public boolean isHouseBlackjack() {
		return houseBlackjack;
	}

	public boolean isGameOver() {
		return gameOver;
	}

}
