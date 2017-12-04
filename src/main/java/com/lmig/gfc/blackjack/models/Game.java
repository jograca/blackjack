package com.lmig.gfc.blackjack.models;

public class Game {

	private Deck deck;
	private Player player;
	private House house;
	private Wallet wallet;
	private Double money;
	private Double bet;

	// Game Flags
	// A reset method sets these back to false
	private boolean playerWins = false;
	private boolean houseWins = false;
	private boolean gamePush = false;
	private boolean playerBlackjack = false;
	private boolean houseBlackjack = false;
	private boolean gameOver = false;
	private boolean gameOn = false;
	private boolean notEnoughFunds = false;

	// Constructor for the game - sets up a deck, player, house and wallet
	public Game() {
		deck = new Deck();
		player = new Player();
		house = new House();
		wallet = new Wallet();
	}

	// Set Game Flags back to False
	public void resetFlags() {

		playerWins = false;
		houseWins = false;
		gamePush = false;
		playerBlackjack = false;
		houseBlackjack = false;
		gameOver = false;
		gameOn = false;
		notEnoughFunds = false;
	}

	// Method to deal:
	// 1) Sets new hands by running the makeNewHand method
	// 2) Runs reset flags method, which set all flags to false
	// 3) Adds cards to the player and dealer hands
	// 4) Determines if the game is an immediate win for the Player
	public void deal() {

		player.makeNewHand();
		house.makeNewHand();
		resetFlags();

		deck.shuffle();
		player.addToHand(deck.pullCardFromDeck());
		player.addToHand(deck.pullCardFromDeck());
		house.addToHand(deck.pullCardFromDeck());
		house.addToHand(deck.pullCardFromDeck());

		playerBlackjack();

	}

	// Method which determines if the game is over
	// sets appropriate flags
	// Push winnings to wallet if appropriate
	public void isGameOverForHand() {

		if (!houseWins) {
			if (house.getHand().getHandTotal() > player.getHand().getHandTotal()) {
				gameOver = true;
				houseWins = true;
			}
			if (player.getHand().getHandTotal() > house.getHand().getHandTotal()) {
				gameOver = true;
				playerWins = true;
				wallet.increaseMoneyBy(getBet());
			}
			if (player.getHand().getHandTotal() == house.getHand().getHandTotal()) {
				gameOver = true;
				gamePush = true;
				wallet.pushMoney(getBet());
			}
			if (playerBlackjack == true && houseBlackjack == true) {
				gameOver = true;
				wallet.pushMoney(getBet());
			}
		}

	}

	// Method to determine if the Dealer Hand went over 21
	// sets appropriate flags
	public void dealerBust() {

		if ((house.getHand().getHandTotal()) > 21) {
			playerWins = true;
			gameOver = true;
			playerBlackjack = false;
			houseBlackjack = false;
		}

	}

	// Method to determine if the Player Hand went over 21
	// sets appropriate flags
	public void playerBust() {

		if (player.getHand().getHandTotal() > 21) {
			houseWins = true;
			gameOver = true;
			gameOn = true;
			playerBlackjack = false;
			houseBlackjack = false;
		}
	}

	// Method to determine if the dealer hit Blackjack
	// sets appropriate flags. Rules:
	// 1) Has 2 cards
	// 2) Hand total is exactly 21
	public void dealerBlackjack() {

		if ((house.getHand().getHandTotal() == 21) && (house.getHand().getHandSize() == 2)) {
			houseWins = true;
			houseBlackjack = true;
			gameOver = true;
		}
	}

	// Method to determine if the player hit Blackjack.
	// sets appropriate flags. Rules:
	// 1) Has 2 cards
	// 2) Hand total is exactly 21
	public void playerBlackjack() {

		if ((player.getHand().getHandTotal() == 21) && (player.getHand().getHandSize() == 2)) {
			playerWins = true;
			playerBlackjack = true;
			gameOver = true;
			gameOn = true;
		}

	}

	// Method to determine if a game was a push.
	// sets appropriate flags. Rules:
	// Hand for both Dealer and Player are the same
	// Game is over
	public void gamePush() {

		if (gameOver = true) {
			if ((player.getHand().getHandTotal()) == (house.getHand().getHandTotal())) {
				gamePush = true;
			}
		}

	}

	// Method to Hit - adds a card to the Player Hand
	// As long as Hand total is under
	// Over 21 runs the method for a Player busting
	public void hit() {

		if (player.getHand().getHandTotal() <= 21) {
			player.addToHand(deck.pullCardFromDeck());
		}
		playerBust();
	}

	// Method to Stay:
	// 1) Determine if the Dealer hit a blackjack
	// 2) Adds cards to Dealer hand until 17 or less is met
	// 3) Determines if the Dealer lost (dealerBust method)
	// 4) Determines the Winner
	public void stay() {

		gameOn = true;

		while (house.getHand().getHandTotal() < 17) {
			house.addToHand(deck.pullCardFromDeck());

			if (house.getHand().getHandTotal() > 21) {
				dealerBust();
			}
		}

		dealerBust();
		isGameOverForHand();
		checkMoney();
	}

	public void checkMoney() {
		if (wallet.getMoney() <= 0) {
			gameOver = true;
		}
	}

	// Method to Payout
	// Accepts a bet Double
	// If the right conditions are met, updates the Wallet with winnings
	public void payout(Double bet) {

		if ((playerWins = true) && (playerBlackjack = false) && (gameOver = true)) {
			wallet.increaseMoneyBy(getBet());

			System.out.println("Normal Win");
		} else if ((playerWins = true) && (playerBlackjack = true) && (gameOver = true)) {
			wallet.blackjackMoneyWin(getBet());

			System.out.println("Blackjack Win");

		} else if ((playerWins = true) && (gamePush = true)) {
			wallet.pushMoney(getBet());
		}
	}

	// Method to make a Player Bet
	// Accepts a bet Double
	// Sets the money variable to the bet
	// Deducts the bet from the overall Wallet
	public void makePlayerBet(Double money) {
		setBet(money);
		wallet.reduceMoneyBy(money);
	}

	// Create a new wallet if it goes below zero
	public void resetWallet() {
		if (wallet.getMoney() <= 0) {
			wallet = new Wallet();
		}

	}

	public void addBlackjackToWallet(Double money) {
		wallet.blackjackMoneyWin(money);
	}

	// Method for Game Over flag
	public boolean gameOver() {
		return gameOver();
	}

	public void verifyFunds(Double money) {
		if (money <= getMoney()) {
			notEnoughFunds = true;
		}
	}

	// Additional Getters and Setters

	public Hand getPlayerHand() {
		return player.getHand();
	}

	public Hand getHouseHand() {
		return house.getHand();
	}

	public Card getHandPositionOne() {
		return house.getHandPositionOne();
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

	public Double getBet() {
		return bet;
	}

	public void setBet(Double bet) {
		this.bet = bet;
	}

	public boolean isNotEnoughFunds() {
		return notEnoughFunds;
	}

	public boolean isGameOn() {
		return gameOn;
	}

}
