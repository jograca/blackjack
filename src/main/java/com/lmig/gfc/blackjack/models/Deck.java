package com.lmig.gfc.blackjack.models;

import java.util.Collections;
import java.util.Stack;

public class Deck {

	private Stack<Card> deck;

	public Deck() {
		deck = new Stack<Card>();
		this.initializeDeck();
		this.shuffle();
	}

	private void initializeDeck() {

		for (int i = 2; i <= 10; i += 1) {

			Card clubs = new NumberCard(Suits.CLUBS, i);
			Card spades = new NumberCard(Suits.SPADES, i);
			Card diamonds = new NumberCard(Suits.DIAMONDS, i);
			Card hearts = new NumberCard(Suits.HEARTS, i);

			deck.push(clubs);
			deck.push(spades);
			deck.push(diamonds);
			deck.push(hearts);
		}

		Card jackClubs = new FaceCard(Suits.CLUBS, Faces.JACK);
		Card jackSpades = new FaceCard(Suits.SPADES, Faces.JACK);
		Card jackDiamonds = new FaceCard(Suits.DIAMONDS, Faces.JACK);
		Card jackHearts = new FaceCard(Suits.HEARTS, Faces.JACK);

		deck.push(jackClubs);
		deck.push(jackSpades);
		deck.push(jackDiamonds);
		deck.push(jackHearts);

		Card kingClubs = new FaceCard(Suits.CLUBS, Faces.KING);
		Card kingSpades = new FaceCard(Suits.SPADES, Faces.KING);
		Card kingDiamonds = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card kingHearts = new FaceCard(Suits.HEARTS, Faces.KING);

		deck.push(kingClubs);
		deck.push(kingSpades);
		deck.push(kingDiamonds);
		deck.push(kingHearts);

		Card queenClubs = new FaceCard(Suits.CLUBS, Faces.QUEEN);
		Card queenSpades = new FaceCard(Suits.SPADES, Faces.QUEEN);
		Card queenDiamonds = new FaceCard(Suits.DIAMONDS, Faces.QUEEN);
		Card queenHearts = new FaceCard(Suits.HEARTS, Faces.QUEEN);

		deck.push(queenClubs);
		deck.push(queenSpades);
		deck.push(queenDiamonds);
		deck.push(queenHearts);

	}

	private void shuffle() {
		Collections.shuffle(deck);
	}

}
