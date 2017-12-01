package com.lmig.gfc.blackjack.models;

public class Game {

	private Deck deck;
	private Player player;
	private House house;
	private Wallet wallet;
	private Double money;

	private boolean playerWins = false;
	private boolean houseWins = false;
	private boolean gamePush = false;
	private boolean playerBlackjack = false;
	private boolean houseBlackjack = false;
	private boolean gameOver = false;

	public Game() {
		this.deck = new Deck();
		this.player = new Player();
		this.house = new House();
		this.wallet = new Wallet();
	}

	public boolean gameOver() {
		return gameOver();
	}

	public void deal() {

		player.makeNewHand();
		house.makeNewHand();
		resetFlags();

		player.addToHand(deck.pullCardFromDeck());
		player.addToHand(deck.pullCardFromDeck());
		house.addToHand(deck.pullCardFromDeck());
		house.addToHand(deck.pullCardFromDeck());

		dealerBlackjack();
		playerBlackjack();

	}

	public void isGameOverForHand() {

		if (!playerWins) {

			if ((house.getHand().getHandTotal()) > (player.getHand().getHandTotal())) {

				System.out.println("IsGameOverForHand");

				houseWins = true;
				gameOver = true;
			}
		}
	}

	public void dealerBust() {
		System.out.println("Dealer Bust");

		if (house.getHand().getHandTotal() > 21) {

			playerWins = true;
			gameOver = true;
		}
	}

	public void playerBust() {

		if (player.getHand().getHandTotal() > 21) {
			System.out.println("Player Busted (went over 21)");

			houseWins = true;
			gameOver = true;

			// addWinToWallet(money);
		}
	}

	public void dealerBlackjack() {
		System.out.println("Dealer Blackjack");
		if (house.getHand().getHandTotal() == 21 && house.getHand().getHandSize() == 2) {

			houseWins = true;
			houseBlackjack = true;
			gameOver = true;
		}
	}

	public void playerBlackjack() {
		System.out.println("Player Blackjack");

		if (player.getHand().getHandTotal() == 21 && player.getHand().getHandSize() == 2) {
			playerWins = true;
			playerBlackjack = true;
			gameOver = true;

			// addBlackjackToWallet(money);
		}

	}

	public void resetFlags() {

		playerWins = false;
		houseWins = false;
		gamePush = false;
		playerBlackjack = false;
		houseBlackjack = false;
		gameOver = false;
	}

	public void hit() {

		if (player.getHand().getHandTotal() <= 21) {
			player.addToHand(deck.pullCardFromDeck());
		}
		playerBust();
	}

	public void stay() {

		while (house.getHand().getHandTotal() < 17) {
			house.addToHand(deck.pullCardFromDeck());
		}
		dealerBust();
		isGameOverForHand();
	}

	public void makePlayerBet(Double bet) {

		wallet.reduceMoneyBy(bet);

	}

	public void addWinToWallet(Double money) {
		if (playerWins = true) {
			wallet.increaseMoneyBy(money);
		}
	}

	public void addBlackjackToWallet(Double money) {
		if (playerWins = true) {
			wallet.blackjackMoneyWin(money);
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

	public Double getMoney() {
		return money;
	}

	// public void findWinner() {
	//
	// if (house.getHand().getHandTotal() > 21) {
	//
	// System.out.println("House Busted (went over 21)");
	//
	// playerWins = true;
	// gameOver = true;
	//
	// addWinToWallet(money);
	// }
	// if (player.getHand().getHandTotal() > 21) {
	//
	// System.out.println("Player Busted (went over 21)");
	//
	// houseWins = true;
	// gameOver = true;
	// }
	// if (player.getHand().getHandTotal() == 21 && player.getHand().getHandSize()
	// == 2) {
	//
	// System.out.println("Player Blackjack");
	//
	// playerWins = true;
	// playerBlackjack = true;
	// gameOver = true;
	//
	// addBlackjackToWallet(money);
	// }
	// if (house.getHand().getHandTotal() == 21 && house.getHand().getHandSize() ==
	// 2) {
	//
	// System.out.println("House Blackjack");
	//
	// houseWins = true;
	// houseBlackjack = true;
	// gameOver = true;
	// }
	// if ((house.getHand().getHandTotal() == 21) &&
	// (player.getHand().getHandTotal() == 21)
	// && (house.getHand().getHandSize() == 2) && (player.getHand().getHandSize() ==
	// 2)) {
	//
	// System.out.println("PUSH Blackjack");
	//
	// gamePush = true;
	// playerBlackjack = true;
	// houseBlackjack = true;
	// gameOver = true;
	//
	// }
	// }

}
