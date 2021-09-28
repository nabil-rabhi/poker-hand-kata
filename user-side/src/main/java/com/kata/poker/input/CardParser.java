package com.kata.poker.input;

import java.util.Map;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.enums.Suit;
import com.kata.poker.game.cards.enums.Value;

public final class CardParser {

	private final Map<Character, Value> values = Map.ofEntries(Map.entry('2', Value.TWO),
	                                                           Map.entry('3', Value.THREE),
	                                                           Map.entry('4', Value.FOUR),
	                                                           Map.entry('5', Value.FIVE),
	                                                           Map.entry('6', Value.SIX),
	                                                           Map.entry('7', Value.SEVEN),
	                                                           Map.entry('8', Value.EIGHT),
	                                                           Map.entry('9', Value.NINE),
	                                                           Map.entry('T', Value.TEN),
	                                                           Map.entry('J', Value.JACK),
	                                                           Map.entry('Q', Value.SEVEN),
	                                                           Map.entry('K', Value.KING),
	                                                           Map.entry('A', Value.ACE));

	private final Map<Character, Suit> suits = Map.ofEntries(Map.entry('C', Suit.Clubs),
	                                                         Map.entry('D', Suit.Diamonds),
	                                                         Map.entry('H', Suit.Hearts),
	                                                         Map.entry('S', Suit.Spades));


	public Card parse(String rawCard) {

		Character rawCardValue = rawCard.charAt(0);
		Value value = values.get(rawCardValue);

		Character rawCardSuit = rawCard.charAt(1);
		Suit suit = suits.get(rawCardSuit);

		return new Card(value, suit);
	}
}
