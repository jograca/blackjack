package com.lmig.gfc.blackjack.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HandTests {

	@Test
	public void HandWithNoAceCaclculatesTotal() {
		Hand hand = new Hand();
		hand.addCardToHand(new NumberCard(Suits.CLUBS, 7));
		hand.addCardToHand(new NumberCard(Suits.DIAMONDS, 3));

		int total = hand.getHandTotal();

		assertThat(total).isEqualTo(10);
	}

	@Test
	public void HandWithOneAceLessThan21() {
		Hand hand = new Hand();
		hand.addCardToHand(new NumberCard(Suits.CLUBS, 7));
		hand.addCardToHand(new AceCard(Suits.HEARTS));

		int total = hand.getHandTotal();

		assertThat(total).isEqualTo(18);
	}

	@Test
	public void HandWithOneAceGreaterThan21ReturnsLessThan21() {
		Hand hand = new Hand();
		hand.addCardToHand(new NumberCard(Suits.CLUBS, 7));
		hand.addCardToHand(new NumberCard(Suits.CLUBS, 7));
		hand.addCardToHand(new AceCard(Suits.HEARTS));

		int total = hand.getHandTotal();

		assertThat(total).isEqualTo(15);
	}

	@Test
	public void HandWithTwoAcesReturnsLessThan21() {
		Hand hand = new Hand();
		hand.addCardToHand(new NumberCard(Suits.CLUBS, 7));
		hand.addCardToHand(new AceCard(Suits.HEARTS));
		hand.addCardToHand(new AceCard(Suits.HEARTS));

		int total = hand.getHandTotal();

		assertThat(total).isEqualTo(19);
	}

	@Test
	public void HandWithTwoAcesAndLotsOfNumbersReturnsLessThan21() {
		Hand hand = new Hand();
		hand.addCardToHand(new NumberCard(Suits.CLUBS, 7));
		hand.addCardToHand(new NumberCard(Suits.CLUBS, 7));
		hand.addCardToHand(new AceCard(Suits.HEARTS));
		hand.addCardToHand(new AceCard(Suits.HEARTS));

		int total = hand.getHandTotal();

		assertThat(total).isEqualTo(16);
	}

}
