package com.lmig.gfc.blackjack.models;

public class Wallet {
	private double money;
	private double playerBet;

	public Wallet() {
		this.money = 100.0;
	}

	public double getPlayerBet() {
		return playerBet;
	}

	public void reduceMoneyBy(double playerBet) {
		money -= playerBet;
	}

	public void increaseMoneyBy(double playerBet) {
		money += playerBet;
	}

	public void blackjackMoneyWin(double playerBet) {
		money = (money + (playerBet * 1.5));
	}

	public double getMoney() {
		return money;
	}

}