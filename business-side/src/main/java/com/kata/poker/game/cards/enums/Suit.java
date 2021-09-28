package com.kata.poker.game.cards.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Suit {
	Clubs('C'),
	Diamonds('D'),
	Hearts('H'),
	Spades('S');

	private final Character value;
}
