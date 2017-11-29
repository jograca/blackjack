package com.lmig.gfc.blackjack.models;

import java.util.Collections;
import java.util.Stack;

public class Deck {

	private Stack<Card> availableCards;
	private Stack<Card> playerCards;
	private Stack<Card> dealerCards;

	public Deck() {
		availableCards = new Stack<Card>();
	}

	public void setupDeck() {
		for (int i = 1; i <= 10; i++) {

			Card spades = new Card("Spades", i, "N/A");
			Card diamonds = new Card("Diamonds", i, "N/A");
			Card hearts = new Card("Hearts", i, "N/A");
			Card clubs = new Card("Clubs", i, "N/A");

			availableCards.push(spades);
			availableCards.push(diamonds);
			availableCards.push(hearts);
			availableCards.push(clubs);
		}
	}

	public void initialDealtoPlayer(Card playerCard1, Card playerCard2) {

		playerCard1 = availableCards.pop();
		playerCard2 = availableCards.pop();

		playerCards.push(playerCard1);
		playerCards.push(playerCard2);
	}

	public void initialDealToDealer(Card dealerCard1, Card dealerCard2) {

		dealerCard1 = availableCards.pop();
		dealerCard2 = availableCards.pop();

		dealerCards.push(dealerCard1);
		dealerCards.push(dealerCard2);

	}

	public void shuffle() {
		Collections.shuffle(availableCards);
	}

	public boolean deckIsEmpty() {
		return availableCards.isEmpty();
	}

	public Stack<Card> getAvailableCards() {
		return availableCards;
	}

}
