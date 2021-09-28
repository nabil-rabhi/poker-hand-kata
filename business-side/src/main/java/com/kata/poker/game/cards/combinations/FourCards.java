package com.kata.poker.game.cards.combinations;

import com.kata.poker.game.cards.Card;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class FourCards {

	private final Card first;
	private final Card second;
	private final Card third;
	private final Card fourth;

	public Card takeOne() {

		return first;
	}
}
