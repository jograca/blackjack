package com.lmig.gfc.blackjack.models;

import java.util.Collections;
import java.util.Stack;

public class Deck {

	private Stack<Card> cards;

	public Deck() {
		cards = new Stack<Card>();
		this.initializeDeck();
	}

	public void initializeDeck() {

		for (int i = 2; i <= 10; i += 1) {

			Card clubs = new NumberCard(Suits.CLUBS, i);
			Card spades = new NumberCard(Suits.SPADES, i);
			Card diamonds = new NumberCard(Suits.DIAMONDS, i);
			Card hearts = new NumberCard(Suits.HEARTS, i);

			cards.push(clubs);
			cards.push(spades);
			cards.push(diamonds);
			cards.push(hearts);
		}

		Card jackClubs = new FaceCard(Suits.CLUBS, Faces.JACK);
		Card jackSpades = new FaceCard(Suits.SPADES, Faces.JACK);
		Card jackDiamonds = new FaceCard(Suits.DIAMONDS, Faces.JACK);
		Card jackHearts = new FaceCard(Suits.HEARTS, Faces.JACK);

		cards.push(jackClubs);
		cards.push(jackSpades);
		cards.push(jackDiamonds);
		cards.push(jackHearts);

		Card kingClubs = new FaceCard(Suits.CLUBS, Faces.KING);
		Card kingSpades = new FaceCard(Suits.SPADES, Faces.KING);
		Card kingDiamonds = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card kingHearts = new FaceCard(Suits.HEARTS, Faces.KING);

		cards.push(kingClubs);
		cards.push(kingSpades);
		cards.push(kingDiamonds);
		cards.push(kingHearts);

		Card queenClubs = new FaceCard(Suits.CLUBS, Faces.QUEEN);
		Card queenSpades = new FaceCard(Suits.SPADES, Faces.QUEEN);
		Card queenDiamonds = new FaceCard(Suits.DIAMONDS, Faces.QUEEN);
		Card queenHearts = new FaceCard(Suits.HEARTS, Faces.QUEEN);

		cards.push(queenClubs);
		cards.push(queenSpades);
		cards.push(queenDiamonds);
		cards.push(queenHearts);

		Card aceClubs = new AceCard(Suits.CLUBS);
		Card aceSpades = new AceCard(Suits.SPADES);
		Card aceDiamonds = new AceCard(Suits.DIAMONDS);
		Card aceHearts = new AceCard(Suits.HEARTS);

		cards.push(aceClubs);
		cards.push(aceSpades);
		cards.push(aceDiamonds);
		cards.push(aceHearts);

	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card pullCardFromDeck() {
		// shuffle();
		return cards.pop();
	}

}
