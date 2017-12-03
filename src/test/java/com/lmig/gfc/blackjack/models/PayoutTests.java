package com.lmig.gfc.blackjack.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PayoutTests {

	@Test
	public void winning_game_returns_2_times_bet() {
		Wallet wallet = new Wallet();
		wallet.increaseMoneyBy(10.0);

		Double total = wallet.getMoney();

		assertThat(total).isEqualTo(110.0);
	}

	@Test
	public void blackjack_winning_game_returns_one_half_times_bet() {
		Wallet wallet = new Wallet();
		wallet.blackjackMoneyWin(10.0);

		Double total = wallet.getMoney();

		assertThat(total).isEqualTo(115.0);
	}

}
