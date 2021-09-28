package com.kata.poker.rules;


import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

public final class StraightRule implements Rule {

	@Override
	public boolean canApply(Hand hand) {

		return hand.hasAllCardsWithConsecutiveValues();
	}

	@Override
	public PlayerRank apply(Hand hand) {

		return PlayerRank.straight(hand.highestCard());
	}
}
