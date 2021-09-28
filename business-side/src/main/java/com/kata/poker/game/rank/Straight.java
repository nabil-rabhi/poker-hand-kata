package com.kata.poker.game.rank;

import java.text.MessageFormat;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.enums.Value;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Straight extends PlayerRank {

	Straight(int priority, Card highestCard) {

		super(priority, highestCard);
	}

	public Value highestCardValue() {

		return highestCard.getValue();
	}

	@Override
	public String display() {

		return MessageFormat.format("straight: {0}-high", formatCardValue(highestCardValue()));
	}


	@Override
	public String toString() {

		return MessageFormat.format("Straight {highestCard={0} }", highestCard);
	}
}
