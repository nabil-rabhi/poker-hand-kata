package com.kata.poker.rules;


import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class StraightFlushRule implements Rule {

	@NonNull
	private final Rule straightRule;

	@NonNull
	private final Rule flushRule;

	@Override
	public boolean canApply(Hand hand) {

		return straightRule.canApply(hand) && flushRule.canApply(hand);
	}

	@Override
	public PlayerRank apply(Hand hand) {

		return PlayerRank.straightFlush(hand.highestCard());
	}
}
