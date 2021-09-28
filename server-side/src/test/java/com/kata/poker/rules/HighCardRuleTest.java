package com.kata.poker.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

import static com.kata.poker.game.cards.enums.Suit.Clubs;
import static com.kata.poker.game.cards.enums.Suit.Diamonds;
import static com.kata.poker.game.cards.enums.Suit.Hearts;
import static com.kata.poker.game.rank.PlayerRank.highCard;
import static com.kata.poker.utils.CardProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

class HighCardRuleTest {

	private Rule ruleUnderTest;

	@BeforeEach
	void setUp() {

		ruleUnderTest = new HighCardRule();
	}

	@Test
	void canApply_should_returnTrue_when_HandHasHighCard() {

		//given
		Hand hand = new Hand(threeOf(Clubs), fiveOf(Diamonds), sevenOf(Hearts), sixOf(Hearts), twoOf(Diamonds));

		//when
		final boolean result = ruleUnderTest.canApply(hand);

		//then
		assertThat(result).isTrue();
	}

	@Test
	void apply_should_returnFlushRank_when_handHasHighCard() {

		//given
		Hand hand = new Hand(threeOf(Clubs), fiveOf(Diamonds), sevenOf(Hearts), sixOf(Hearts), twoOf(Diamonds));
		PlayerRank expected = highCard(sevenOf(Hearts));

		//when
		final PlayerRank actual = ruleUnderTest.apply(hand);

		//then
		assertThat(actual).isEqualTo(expected);
	}
}
