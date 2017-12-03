package com.lmig.gfc.blackjack.models;

public class Wallet {
	private Double money;
	private Double playerBet;

	public Wallet() {
		this.money = 100.0;
	}

	public double getPlayerBet() {
		return playerBet;
	}

	public void reduceMoneyBy(Double playerBet) {
		money -= playerBet;
	}

	public void increaseMoneyBy(Double playerBet) {
		money += playerBet;
	}

	public void blackjackMoneyWin(Double playerBet) {
		money = (money + (playerBet * 1.5));
	}

	public void calculateWinning() {

	}

	public double getMoney() {
		return money;
	}

}