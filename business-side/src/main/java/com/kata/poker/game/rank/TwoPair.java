package com.kata.poker.game.rank;

import java.text.MessageFormat;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.cards.enums.Value;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode

public class TwoPair extends PlayerRank {

	private final Value firstPairValue;
	private final Value secondPairValue;

	public TwoPair(int priority, Card highestCard, TwoCards firstPair, TwoCards secondPair) {

		super(priority, highestCard);
		this.firstPairValue = firstPair.getFirst().getValue();
		this.secondPairValue = secondPair.getFirst().getValue();
	}

	public Value lowestRankingPairValue() {

		return Value.min(firstPairValue, secondPairValue);
	}


	@Override
	public String display() {

		return MessageFormat.format("two pairs: {0}s and {1}s",
		                            formatCardValue(highestCard.getValue()),
		                            formatCardValue(lowestRankingPairValue()));
	}

}
