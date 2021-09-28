package com.kata.poker.rules;

import java.util.Objects;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.CardCombination;
import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.cards.combinations.ThreeCards;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.rank.PlayerRank;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public final class FullHouseRule implements Rule {

	private final ThreeOfKindRule threeOfKindRule;
	private final PairRule pairRule;

	@Override
	public boolean canApply(final Hand hand) {

		if (threeOfKindRule.canApply(hand)) {
			ThreeCards threeCards = hand.selectThreeCardsWithTheSameValue().orElse(null);
			Objects.requireNonNull(threeCards);
			CardCombination remainingCards = hand.allCardsExcept(threeCards.getFirst(),
			                                                     threeCards.getSecond(),
			                                                     threeCards.getThird());
			Hand newHand = new Hand(remainingCards);
			return pairRule.canApply(newHand);
		}
		return false;
	}

	@Override
	public PlayerRank apply(final Hand hand) {

		TwoCards twoCards = hand.selectTwoCardsWithTheSameValue().orElse(null);
		Objects.requireNonNull(twoCards);

		ThreeCards threeCards = hand.selectThreeCardsWithTheSameValue().orElse(null);
		Objects.requireNonNull(threeCards);

		final Card highestCard = threeCards.takeOne();

		return PlayerRank.fullHouse(highestCard, twoCards);
	}
}
