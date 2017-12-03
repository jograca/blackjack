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

	// Constructor for the game - sets up a deck, player, house and wallet
	public Game() {
		deck = new Deck();
		player = new Player();
		house = new House();
		wallet = new Wallet();
	}

	// Method for Game Over flag
	public boolean gameOver() {
		return gameOver();
	}

	// Sets all needed game flags to false
	public void resetFlags() {

		playerWins = false;
		houseWins = false;
		gamePush = false;
		playerBlackjack = false;
		houseBlackjack = false;
		gameOver = false;
	}

	// Method to deal
	// 1) Sets new hands by running the makeNewHand method
	// 2) Runs reset flags method, which set all flags to false
	// 3) Adds 2 cards to the player and dealer hands
	// 4) Runs the blackjack methods
	// This determines if the game is an immediate win for player or dealer
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

	// Method which determines if the game is over
	// sets appropriate flags
	public void isGameOverForHand() {

		if (!playerWins) {

			if ((house.getHand().getHandTotal()) > (player.getHand().getHandTotal())) {

				System.out.println("IsGameOverForHand");

				houseWins = true;
				gameOver = true;
			}
		}
	}

	// Method to determine if the Dealer Hand went over 21
	public void dealerBust() {
		System.out.println("Dealer Bust");

		if (house.getHand().getHandTotal() > 21) {

			playerWins = true;
			gameOver = true;
		}
	}

	// Method to determine if the Player Hand went over 21
	public void playerBust() {

		if (player.getHand().getHandTotal() > 21) {
			System.out.println("Player Busted (went over 21)");

			houseWins = true;
			gameOver = true;
		}
	}

	// Method to determine if the dealer hit Blackjack. Rules:
	// 1) Has 2 cards
	// 2) Hand total is exactly 21
	public void dealerBlackjack() {
		System.out.println("Dealer Blackjack");
		if (house.getHand().getHandTotal() == 21 && house.getHand().getHandSize() == 2) {

			houseWins = true;
			houseBlackjack = true;
			gameOver = true;
		}
	}

	// Method to determine if the player hit Blackjack. Rules:
	// 1) Has 2 cards
	// 2) Hand total is exactly 21
	public void playerBlackjack() {
		System.out.println("Player Blackjack");

		if (player.getHand().getHandTotal() == 21 && player.getHand().getHandSize() == 2) {
			playerWins = true;
			playerBlackjack = true;
			gameOver = true;
		}

	}

	// Method to Pay on a Win
	public void payout() {
		System.out.println("Money Is: " + money);

		if (playerWins = true) {
			addWinToWallet(money);
		}
	}

	// Method to Hit - adds a card to the Player Hand
	public void hit() {

		if (player.getHand().getHandTotal() <= 21) {
			player.addToHand(deck.pullCardFromDeck());
		}
		playerBust();
	}

	// Method to Stay:
	// 1) Adds cards to Deler hand until 17 or less is met
	// 2) Determines if the Dealer lost (dealerBust method)
	// 3) Determines the Winner
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

	public void addWinToWallet(Double bet) {
		wallet.increaseMoneyBy(bet);
	}

	public void addBlackjackToWallet(Double money) {
		wallet.blackjackMoneyWin(money);
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

}
