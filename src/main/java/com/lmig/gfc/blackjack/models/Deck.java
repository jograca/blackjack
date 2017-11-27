package com.lmig.gfc.blackjack.models;

import java.util.Collections;
import java.util.Stack;

public class Deck {

	private Stack<Card> availableCards;
	private Stack<Card> playerCards;
	private Stack<Card> dealerCards;

	public Deck() {
		availableCards = new Stack<Card>();
		playerCards = new Stack<Card>();
		dealerCards = new Stack<Card>();
	}
	
	public boolean deckIsEmpty() {
		return availableCards.isEmpty();
	}
	
	public void setupDeck() {
		for (int i = 1; i <= 10; i++) {
			
			Card spades = new Card("Spades", i);
			Card diamonds = new Card("Diamonds", i);
			Card hearts = new Card("Hearts", i);
			Card clubs = new Card("Clubs", i);			
			
			availableCards.push(spades);
			availableCards.push(diamonds);
			availableCards.push(hearts);
			availableCards.push(clubs);
		}		
	}
	
	public void shuffle() {
		Collections.shuffle(availableCards);
	}
	
	public void initialDeal() {
		Card playerCard1 = availableCards.pop();
		Card playerCard2 = availableCards.pop();
		
		Card dealerCard1 = availableCards.pop();
		Card dealerCard2 = availableCards.pop();
		
		playerCards.push(playerCard1);
		playerCards.push(playerCard2);
		
		dealerCards.push(dealerCard1);
		dealerCards.push(dealerCard2);
	}

	public Stack<Card> getAvailableCards() {
		return availableCards;
	}

	public Stack<Card> getPlayerCards() {
		return playerCards;
	}

	public Stack<Card> getDealerCards() {
		return dealerCards;
	}
	
}
