package com.lmig.gfc.blackjack.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PayoutTests {

	@Test
	public void winning_game_returns_2_times_bet() {
		Wallet wallet = new Wallet();
		wallet.reduceMoneyBy(20.0);
		wallet.increaseMoneyBy(20.0);

		Double total = wallet.getMoney();

		assertThat(total).isEqualTo(120.0);
	}

	@Test
	public void blackjack_winning_game_returns_one_half_times_bet() {
		Wallet wallet = new Wallet();
		wallet.reduceMoneyBy(20.0);
		wallet.blackjackMoneyWin(20.0);

		Double total = wallet.getMoney();

		assertThat(total).isEqualTo(130.0);
	}

	@Test
	public void push_returns_player_money() {
		Wallet wallet = new Wallet();
		wallet.reduceMoneyBy(20.0);
		wallet.pushMoney(20.0);

		Double total = wallet.getMoney();

		assertThat(total).isEqualTo(100.0);

	}

}
