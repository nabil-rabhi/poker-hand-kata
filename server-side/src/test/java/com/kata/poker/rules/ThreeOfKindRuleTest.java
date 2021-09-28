package com.kata.poker.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

import static com.kata.poker.game.cards.enums.Suit.Clubs;
import static com.kata.poker.game.cards.enums.Suit.Diamonds;
import static com.kata.poker.game.cards.enums.Suit.Hearts;
import static com.kata.poker.game.rank.PlayerRank.flush;
import static com.kata.poker.game.rank.PlayerRank.threeOfKind;
import static com.kata.poker.utils.CardProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

class ThreeOfKindRuleTest {

	private Rule ruleUnderTest;

	@BeforeEach
	void setUp() {

		ruleUnderTest = new ThreeOfKindRule();
	}

	@Test
	void canApply_should_returnTrue_when_HandIsThreeOfAKind() {

		//given
		Hand hand = new Hand(fiveOf(Diamonds), fiveOf(Hearts), fiveOf(Clubs), fourOf(Clubs), sixOf(Hearts));

		//when
		final boolean result = ruleUnderTest.canApply(hand);

		//then
		assertThat(result).isTrue();
	}

	@Test
	void apply_should_returnFlushRank_when_handIsThreeOfAKind() {

		//given
		Hand hand = new Hand(fiveOf(Diamonds), fiveOf(Hearts), fiveOf(Clubs), fourOf(Clubs), sixOf(Hearts));
		PlayerRank expected = threeOfKind(fiveOf(Diamonds));

		//when
		final PlayerRank actual = ruleUnderTest.apply(hand);

		//then
		assertThat(actual).isEqualTo(expected);
	}
}
