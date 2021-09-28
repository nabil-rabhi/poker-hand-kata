package com.kata.poker.rules;

import java.util.List;
import java.util.Objects;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.rank.PlayerRank;

public final class TwoPairRule implements Rule {

	@Override
	public boolean canApply(Hand hand) {

		return hand.selectCoupleOfTwoCardsWithTheSameValue().isPresent();
	}

	@Override
	public PlayerRank apply(Hand hand) {

		List<TwoCards> twoPair = hand.selectCoupleOfTwoCardsWithTheSameValue().orElse(null);
		Objects.requireNonNull(twoPair);

		final TwoCards firstPair = twoPair.get(0);
		final TwoCards secondPair = twoPair.get(1);

		return PlayerRank.twoPair(firstPair, secondPair);
	}

}
