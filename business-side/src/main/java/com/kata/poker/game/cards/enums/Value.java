package com.kata.poker.game.cards.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Value {

	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(11),
	QUEEN(12),
	KING(13),
	ACE(14);

	public final Integer numericValue;

	public static Value min(Value first, Value second) {

		return first.numericValue < second.numericValue ? first : second;
	}

	public static Value max(Value first, Value second) {

		return first.numericValue > second.numericValue ? first : second;
	}

	public boolean doesComeBefore(Value otherValue) {

		return numericValue + 1 == otherValue.numericValue;
	}
}
