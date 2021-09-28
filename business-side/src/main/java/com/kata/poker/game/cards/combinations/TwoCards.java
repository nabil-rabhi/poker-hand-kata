package com.kata.poker.game.cards.combinations;

import com.kata.poker.game.cards.Card;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class TwoCards {

	private final Card first;
	private final Card second;

}
