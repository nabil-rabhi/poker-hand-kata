package com.kata.poker.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

import static com.kata.poker.game.cards.enums.Suit.Clubs;
import static com.kata.poker.game.cards.enums.Suit.Diamonds;
import static com.kata.poker.game.cards.enums.Suit.Hearts;
import static com.kata.poker.game.rank.PlayerRank.fourOfKind;
import static com.kata.poker.utils.CardProvider.fiveOf;
import static com.kata.poker.utils.CardProvider.sixOf;
import static org.assertj.core.api.Assertions.assertThat;

class FourOfKindRuleTest {

	private Rule ruleUnderTest;

	@BeforeEach
	void setUp() {

		ruleUnderTest = new FourOfKindRule();
	}

	@Test
	void canApply_should_returnTrue_when_HandIsFourOfAKind() {

		//given
		Hand hand = new Hand(fiveOf(Diamonds), fiveOf(Hearts), fiveOf(Clubs), fiveOf(Clubs), sixOf(Hearts));

		//when
		final boolean result = ruleUnderTest.canApply(hand);

		//then
		assertThat(result).isTrue();
	}

	@Test
	void apply_should_returnFlushRank_when_handIsFourOfAKind() {

		//given
		Hand hand = new Hand(fiveOf(Diamonds), fiveOf(Hearts), fiveOf(Clubs), fiveOf(Clubs), sixOf(Hearts));
		PlayerRank expected = fourOfKind(fiveOf(Diamonds));

		//when
		final PlayerRank actual = ruleUnderTest.apply(hand);

		//then
		assertThat(actual).isEqualTo(expected);
	}
}
