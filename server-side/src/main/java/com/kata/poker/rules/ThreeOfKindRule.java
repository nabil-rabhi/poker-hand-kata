package com.kata.poker.rules;

import java.util.Objects;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.combinations.ThreeCards;
import com.kata.poker.game.rank.PlayerRank;

public final class ThreeOfKindRule implements Rule {

	@Override
	public boolean canApply(Hand hand) {

		return hand.hasThreeCardsWithTheSameValue();
	}

	@Override
	public PlayerRank apply(Hand hand) {

		ThreeCards threeCards = hand.selectThreeCardsWithTheSameValue().orElse(null);
		Objects.requireNonNull(threeCards);

		final Card card = threeCards.takeOne();

		return PlayerRank.threeOfKind(card);
	}

}
