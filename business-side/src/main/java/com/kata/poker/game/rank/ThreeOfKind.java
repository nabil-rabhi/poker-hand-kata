package com.kata.poker.game.rank;

import java.text.MessageFormat;

import com.kata.poker.game.cards.Card;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ThreeOfKind extends PlayerRank {

	public ThreeOfKind(int priority, Card highestCard) {

		super(priority, highestCard);
	}

	@Override
	public String display() {

		return MessageFormat.format("three of a kind: {0}s",
		                            formatCardValue(highestCard.getValue()));
	}

}
