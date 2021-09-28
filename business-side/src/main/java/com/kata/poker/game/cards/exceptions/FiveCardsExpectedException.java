package com.kata.poker.game.cards.exceptions;

import java.text.MessageFormat;

public class FiveCardsExpectedException extends RuntimeException {

	private static final long serialVersionUID = -8302192060790156164L;

	public FiveCardsExpectedException(final int numberOfCards) {

		super(MessageFormat.format("expected a deck with 5 cards but found {0}",
		                           numberOfCards));
	}
}
