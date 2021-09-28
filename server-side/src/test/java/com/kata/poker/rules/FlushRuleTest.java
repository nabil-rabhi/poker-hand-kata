package com.kata.poker.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

import static com.kata.poker.game.cards.enums.Suit.Hearts;
import static com.kata.poker.game.rank.PlayerRank.flush;
import static com.kata.poker.utils.CardProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

class FlushRuleTest {

	private Rule ruleUnderTest;

	@BeforeEach
	void setUp() {

		ruleUnderTest = new FlushRule();
	}

	@Test
	void canApply_should_returnTrue_when_HandIsFlush() {

		//given
		Hand hand = new Hand(fiveOf(Hearts), sevenOf(Hearts), threeOf(Hearts), twoOf(Hearts), jackOf(Hearts));

		//when
		final boolean result = ruleUnderTest.canApply(hand);

		//then
		assertThat(result).isTrue();
	}

	@Test
	void apply_should_returnFlushRank_when_handIsFlush() {

		//given
		Hand hand = new Hand(fiveOf(Hearts), sevenOf(Hearts), threeOf(Hearts), twoOf(Hearts), jackOf(Hearts));
		PlayerRank expected = flush(jackOf(Hearts));

		//when
		final PlayerRank actual = ruleUnderTest.apply(hand);

		//then
		assertThat(actual).isEqualTo(expected);
	}
}
