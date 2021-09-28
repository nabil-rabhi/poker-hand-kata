package com.kata.poker.rules;

import java.util.Objects;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.combinations.FourCards;
import com.kata.poker.game.rank.PlayerRank;

public final class FourOfKindRule implements Rule {

	@Override
	public boolean canApply(Hand hand) {

		return hand.hasFourCardsWithTheSameValue();
	}

	@Override
	public PlayerRank apply(Hand hand) {

		FourCards fourCards = hand.selectFourCardsWithTheSameValue().orElse(null);
		Objects.requireNonNull(fourCards);

		final Card card = fourCards.takeOne();

		return PlayerRank.fourOfKind(card);
	}

}
