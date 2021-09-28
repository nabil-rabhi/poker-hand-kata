package com.kata.poker.adapters;

import java.util.List;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;
import com.kata.poker.ports.GameRulesAdapter;
import com.kata.poker.rules.*;

public final class GameRulesAdapterImpl implements GameRulesAdapter {

	private final List<Rule> rules;

	public GameRulesAdapterImpl() {

		final FlushRule flushRule = new FlushRule();
		final StraightRule straightRule = new StraightRule();

		final ThreeOfKindRule threeOfKindRule = new ThreeOfKindRule();
		final PairRule pairRule = new PairRule();

		rules = List.of(new HighCardRule(),
		                pairRule,
		                new TwoPairRule(),
		                threeOfKindRule,
		                straightRule,
		                flushRule,
		                new FullHouseRule(threeOfKindRule, pairRule),
		                new StraightFlushRule(straightRule, flushRule),
		                new FourOfKindRule());
	}

	@Override
	public PlayerRank evaluate(Hand hand) {

		return rules.stream()
		            .filter(rule -> rule.canApply(hand))
		            .map(rule -> rule.apply(hand))
		            .max(PlayerRank::compareTo)
		            .orElse(null);
	}
}
