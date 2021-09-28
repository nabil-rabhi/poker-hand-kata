package com.kata.poker.rules;

import java.util.Objects;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.cards.CardCombination;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.rank.PlayerRank;

public class PairRule implements Rule {

	@Override
	public boolean canApply(Hand hand) {

		return hand.hasTwoCardsWithTheSameValue();
	}

	@Override
	public PlayerRank apply(Hand hand) {

		TwoCards twoCards = hand.selectTwoCardsWithTheSameValue().orElse(null);
		Objects.requireNonNull(twoCards);

		CardCombination remainingCards = hand.allCardsExcept(twoCards.getFirst(),
		                                                     twoCards.getSecond());
		return PlayerRank.pair(twoCards, remainingCards.highestCard());
	}

}
