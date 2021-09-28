package com.kata.poker.game.rank;

import java.text.MessageFormat;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.cards.enums.Value;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Pair extends PlayerRank {

	private final Card first;
	private final Card second;
	private final Card highestRankingKicker;

	public Pair(int priority, TwoCards twoCards, Card highestRankingKicker) {

		super(priority, twoCards.getFirst());

		this.first = twoCards.getFirst();
		this.second = twoCards.getSecond();
		this.highestRankingKicker = highestRankingKicker;
	}

	public Value getValue() {

		return first.getValue();
	}

	@Override
	public boolean isHigherThan(PlayerRank anotherPalyerPlayerRank) {

		if (super.isHigherThan(anotherPalyerPlayerRank)) {
			return true;
		}

		return isPair(anotherPalyerPlayerRank) && hasHighestKickerThan(anotherPalyerPlayerRank);
	}

	@Override
	public String display() {

		return MessageFormat.format("pair: {0}s", formatCardValue(getValue()));
	}

	private boolean isPair(PlayerRank playerRank) {

		return playerRank instanceof Pair;
	}

	private boolean hasHighestKickerThan(PlayerRank playerRank) {

		Pair otherPair = (Pair) playerRank;
		return highestRankingKicker.isHigherThan(otherPair.highestRankingKicker);
	}

	@Override
	public String toString() {

		return MessageFormat.format("Pair'{'first={0}, second={1}, highestRankingKicker={2}'}'",
		                            first,
		                            second,
		                            highestRankingKicker);
	}
}
