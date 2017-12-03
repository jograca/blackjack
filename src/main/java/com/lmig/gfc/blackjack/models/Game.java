package com.lmig.gfc.blackjack.models;

public class Game {

	private Deck deck;
	private Player player;
	private House house;
	private Wallet wallet;
	private Double money;
	private Double bet;

	private String firstCard;

	// Game Flags
	// A reset method sets these back to false
	private boolean playerWins = false;
	private boolean houseWins = false;
	private boolean gamePush = false;
	private boolean playerBlackjack = false;
	private boolean houseBlackjack = false;
	private boolean gameOver = false;
	private boolean outOfMoney = false;

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
		outOfMoney = false;
	}

	// Method to deal:
	// 1) Sets new hands by running the makeNewHand method
	// 2) Runs reset flags method, which set all flags to false
	// 3) Adds 2 cards to the player and dealer hands
	// 4) Determines if the game is an immediate win for either side
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

		System.out.println(" ");
		System.out.println("Evaluating Hand");
		System.out.println("House Hand: " + house.getHand().getHandTotal());
		System.out.println("Player Hand: " + player.getHand().getHandTotal());
		System.out.println(" ");

		if (!playerWins) {

			if ((house.getHand().getHandTotal()) > (player.getHand().getHandTotal())) {
				houseWins = true;
			}
			if ((player.getHand().getHandTotal()) > (house.getHand().getHandTotal())) {
				playerWins = true;
			}
			if ((player.getHand().getHandTotal()) == (house.getHand().getHandTotal())) {
				gamePush = true;
			}
			gameOver = true;

			System.out.println("Player Wins:" + playerWins);
			System.out.println("Dealer Wins:" + houseWins);
			System.out.println("Game Push: " + gamePush);
			System.out.println("Player Blackjack: " + playerBlackjack);
			System.out.println("House Blackjack: " + houseBlackjack);
			System.out.println("Game Over: " + gameOver);

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

		System.out.println(" ");
		System.out.println(house.getHand().getHandTotal());
		System.out.println("Dealer Bust Method");
		System.out.println(" ");
		System.out.println("Player Wins:" + playerWins);
		System.out.println("Dealer Wins:" + houseWins);
		System.out.println("Game Push: " + gamePush);
		System.out.println("Player Blackjack: " + playerBlackjack);
		System.out.println("House Blackjack: " + houseBlackjack);
		System.out.println("Game Over: " + gameOver);

	}

	// Method to determine if the Player Hand went over 21
	// sets appropriate flags
	public void playerBust() {

		if (player.getHand().getHandTotal() > 21) {
			houseWins = true;
			gameOver = true;
			playerBlackjack = false;
			houseBlackjack = false;
		}

		System.out.println(" ");
		System.out.println(player.getHand().getHandTotal());
		System.out.println("Player Bust Method");
		System.out.println(" ");
		System.out.println("Player Wins:" + playerWins);
		System.out.println("Dealer Wins:" + houseWins);
		System.out.println("Game Push: " + gamePush);
		System.out.println("Player Blackjack: " + playerBlackjack);
		System.out.println("House Blackjack: " + houseBlackjack);
		System.out.println("Game Over: " + gameOver);
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

		System.out.println(" ");
		System.out.println("Dealer Blackjack Check");
		System.out.println(" ");
		System.out.println("Player Wins:" + playerWins);
		System.out.println("Dealer Wins:" + houseWins);
		System.out.println("Game Push: " + gamePush);
		System.out.println("Player Blackjack: " + playerBlackjack);
		System.out.println("House Blackjack: " + houseBlackjack);
		System.out.println("Game Over: " + gameOver);
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
		}

		System.out.println(" ");
		System.out.println("Player Blackjack Check");
		System.out.println(" ");
		System.out.println("Player Wins:" + playerWins);
		System.out.println("Dealer Wins:" + houseWins);
		System.out.println("Game Push: " + gamePush);
		System.out.println("Player Blackjack: " + playerBlackjack);
		System.out.println("House Blackjack: " + houseBlackjack);
		System.out.println("Game Over: " + gameOver);

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

		System.out.println(" ");
		System.out.println("Push Met");
		System.out.println(" ");
		System.out.println("Player Wins:" + playerWins);
		System.out.println("Dealer Wins:" + houseWins);
		System.out.println("Game Push: " + gamePush);
		System.out.println("Player Blackjack: " + playerBlackjack);
		System.out.println("House Blackjack: " + houseBlackjack);
		System.out.println("Game Over: " + gameOver);

	}

	public String showFirstCard() {
		return firstCard;
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
	// 1) Adds cards to Dealer hand until 17 or less is met
	// 2) Determines if the Dealer lost (dealerBust method)
	// 3) Determines the Winner
	public void stay() {

		playerWins = false;
		houseWins = false;
		playerBlackjack = false;
		houseBlackjack = false;

		while (house.getHand().getHandTotal() < 17) {
			house.addToHand(deck.pullCardFromDeck());
			if (house.getHand().getHandTotal() > 21) {
				dealerBust();
			}
		}
		isGameOverForHand();
	}

	// Method to Payout
	// Accepts a bet Double
	// If the right conditions are met, updates the Wallet with winnings
	public void payout(Double bet) {

		if ((playerWins = true) && (playerBlackjack = true) && (gameOver = true)) {
			System.out.println("blackjack win");
			wallet.blackjackMoneyWin(getBet());
		}
		if ((playerWins = true) && (playerBlackjack = false) && (gameOver = true)) {
			System.out.println("regular win");
			wallet.increaseMoneyBy(bet);
		} else if (!playerWins) {
			wallet.reduceMoneyBy(bet);
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

	public void addBlackjackToWallet(Double money) {
		wallet.blackjackMoneyWin(money);
	}

	// Method for Game Over flag
	public boolean gameOver() {
		return gameOver();
	}

	// Additional Getters and Setters

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

	public Double getBet() {
		return bet;
	}

	public void setBet(Double bet) {
		this.bet = bet;
	}

}
