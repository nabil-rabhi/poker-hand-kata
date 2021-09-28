package com.kata.poker.input;

import java.util.Collection;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.cards.Card;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class HandParser {

	@NonNull
	private final CardParser cardParser;

	public Hand parse(Collection<String> cardInput) {

		return new Hand(cardsFrom(cardInput));
	}

	private Card[] cardsFrom(Collection<String> cardInput) {

		return cardInput.stream()
		                .map(cardParser::parse)
		                .toArray(Card[]::new);
	}
}
