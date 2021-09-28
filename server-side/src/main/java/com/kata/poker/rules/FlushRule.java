package com.kata.poker.rules;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

public final class FlushRule implements Rule {

	@Override
	public boolean canApply(Hand hand) {

		return hand.hasAllCardsWithTheSameSuit();
	}

	@Override
	public PlayerRank apply(Hand hand) {

		return PlayerRank.flush(hand.highestCard());
	}
}
