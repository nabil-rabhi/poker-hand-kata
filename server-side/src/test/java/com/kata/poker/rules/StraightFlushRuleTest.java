package com.kata.poker.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

import static com.kata.poker.game.cards.enums.Suit.Clubs;
import static com.kata.poker.game.rank.PlayerRank.straightFlush;
import static com.kata.poker.utils.CardProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

class StraightFlushRuleTest {

	private Rule ruleUnderTest;

	@BeforeEach
	void setUp() {

		ruleUnderTest = new StraightFlushRule(new StraightRule(), new FlushRule());
	}

	@Test
	void canApply_should_returnTrue_when_HandIsStraightFlush() {

		//given
		Hand hand = new Hand(twoOf(Clubs), threeOf(Clubs), fourOf(Clubs), fiveOf(Clubs), sixOf(Clubs));

		//when
		final boolean result = ruleUnderTest.canApply(hand);

		//then
		assertThat(result).isTrue();
	}

	@Test
	void apply_should_returnFlushRank_when_handIsStraightFlush() {

		//given
		Hand hand = new Hand(twoOf(Clubs), threeOf(Clubs), fourOf(Clubs), fiveOf(Clubs), sixOf(Clubs));
		PlayerRank expected = straightFlush(sixOf(Clubs));

		//when
		final PlayerRank actual = ruleUnderTest.apply(hand);

		//then
		assertThat(actual).isEqualTo(expected);
	}
}
