package com.kata.poker.game.cards;

import java.text.MessageFormat;

import com.kata.poker.game.cards.enums.Suit;
import com.kata.poker.game.cards.enums.Value;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public final class Card implements Comparable<Card> {

	@NonNull
	private final Value value;

	@NonNull
	private final Suit suit;

	@Override
	public int compareTo(Card otherCard) {

		return value.numericValue.compareTo(otherCard.value.numericValue);
	}

	public boolean doesComeBefore(Card card) {

		return value.doesComeBefore(card.value);
	}

	public boolean isHigherThan(Card otherCard) {

		return value.numericValue > otherCard.value.numericValue;
	}

	@Override
	public String toString() {

		return MessageFormat.format("{0} of {1}", value, suit);
	}

}
