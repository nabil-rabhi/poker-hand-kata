package com.kata.poker.rules;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

public final class HighCardRule implements Rule {

	@Override
	public boolean canApply(Hand hand) {

		return true;
	}

	@Override
	public PlayerRank apply(Hand hand) {

		return PlayerRank.highCard(hand.highestCard());
	}
}
