package com.kata.poker.utils;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.enums.Suit;
import com.kata.poker.game.cards.enums.Value;

//TODO à deplacer vers un projet core ou common
public class CardProvider {

	private CardProvider() {}

	public static Card twoOf(Suit suit) {

		return new Card(Value.TWO, suit);
	}

	public static Card threeOf(Suit suit) {

		return new Card(Value.THREE, suit);
	}

	public static Card fourOf(Suit suit) {

		return new Card(Value.FOUR, suit);
	}

	public static Card fiveOf(Suit suit) {

		return new Card(Value.FIVE, suit);
	}

	public static Card sixOf(Suit suit) {

		return new Card(Value.SIX, suit);
	}

	public static Card sevenOf(Suit suit) {

		return new Card(Value.SEVEN, suit);
	}

	public static Card eightOf(Suit suit) {

		return new Card(Value.EIGHT, suit);
	}

	public static Card nineOf(Suit suit) {

		return new Card(Value.NINE, suit);
	}

	public static Card tenOf(Suit suit) {

		return new Card(Value.TEN, suit);
	}

	public static Card jackOf(Suit suit) {

		return new Card(Value.JACK, suit);
	}

	public static Card queenOf(Suit suit) {

		return new Card(Value.QUEEN, suit);
	}

	public static Card kingOf(Suit suit) {

		return new Card(Value.KING, suit);
	}

	public static Card aceOf(Suit suit) {

		return new Card(Value.ACE, suit);
	}
}
