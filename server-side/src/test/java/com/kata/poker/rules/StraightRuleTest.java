package com.kata.poker.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

import static com.kata.poker.game.cards.enums.Suit.Clubs;
import static com.kata.poker.game.cards.enums.Suit.Diamonds;
import static com.kata.poker.game.cards.enums.Suit.Hearts;
import static com.kata.poker.game.rank.PlayerRank.straight;
import static com.kata.poker.utils.CardProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

class StraightRuleTest {

	private Rule ruleUnderTest;

	@BeforeEach
	void setUp() {

		ruleUnderTest = new StraightRule();
	}

	@Test
	void canApply_should_returnTrue_when_HandIsStraight() {

		//given
		Hand hand = new Hand(twoOf(Diamonds), threeOf(Clubs), fourOf(Diamonds), fiveOf(Hearts), sixOf(Hearts));

		//when
		final boolean result = ruleUnderTest.canApply(hand);

		//then
		assertThat(result).isTrue();
	}

	@Test
	void apply_should_returnFlushRank_when_handIsStraight() {

		//given
		Hand hand = new Hand(twoOf(Diamonds), threeOf(Clubs), fourOf(Diamonds), fiveOf(Hearts), sixOf(Hearts));
		PlayerRank expected = straight(sixOf(Hearts));

		//when
		final PlayerRank actual = ruleUnderTest.apply(hand);

		//then
		assertThat(actual).isEqualTo(expected);
	}
}
