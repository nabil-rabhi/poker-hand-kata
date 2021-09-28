package com.kata.poker.game.rank;

import java.text.MessageFormat;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.enums.Value;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public final class Flush extends PlayerRank {

	public Flush(int priority, Card highestCard) {

		super(priority, highestCard);
	}

	public Value highestCardValue() {

		return highestCard.getValue();
	}

	@Override
	public String display() {

		return MessageFormat.format("flush: {0}-high", formatCardValue(highestCardValue()));
	}

}
