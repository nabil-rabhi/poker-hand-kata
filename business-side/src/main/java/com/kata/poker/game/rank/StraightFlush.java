package com.kata.poker.game.rank;

import java.text.MessageFormat;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.enums.Value;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class StraightFlush extends PlayerRank {

	public StraightFlush(int priority, Card highestCard) {

		super(priority, highestCard);
	}

	public Value highestCardValue() {

		return highestCard.getValue();
	}

	@Override
	public String display() {

		return MessageFormat.format("straight flush: {0}-high",
		                            formatCardValue(highestCardValue()));
	}

}
