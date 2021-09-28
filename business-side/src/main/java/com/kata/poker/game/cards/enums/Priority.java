package com.kata.poker.game.cards.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//todo à utiliser à la place des valeurs int lors de la création du rank pour enfrocer plus le typage
@RequiredArgsConstructor
@Getter
public enum Priority {
	HIGH_CARD_PRIORRITY(1),
	PAIR_PRIORITY(2);

	private final int priority;
}
