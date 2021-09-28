package com.kata.poker.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.rank.PlayerRank;

import static com.kata.poker.game.cards.enums.Suit.Clubs;
import static com.kata.poker.game.cards.enums.Suit.Diamonds;
import static com.kata.poker.game.cards.enums.Suit.Hearts;
import static com.kata.poker.game.rank.PlayerRank.pair;
import static com.kata.poker.utils.CardProvider.fiveOf;
import static com.kata.poker.utils.CardProvider.fourOf;
import static com.kata.poker.utils.CardProvider.sixOf;
import static com.kata.poker.utils.CardProvider.twoOf;
import static org.assertj.core.api.Assertions.assertThat;

class PairRuleTest {

	private Rule ruleUnderTest;

	@BeforeEach
	void setUp() {

		ruleUnderTest = new PairRule();
	}

	@Test
	void canApply_should_returnTrue_when_HandHasPair() {

		//given
		Hand hand = new Hand(fiveOf(Clubs), fiveOf(Diamonds), fourOf(Hearts), sixOf(Hearts), twoOf(Diamonds));

		//when
		final boolean result = ruleUnderTest.canApply(hand);

		//then
		assertThat(result).isTrue();
	}

	@Test
	void apply_should_returnFlushRank_when_handHasPair() {

		//given
		Hand hand = new Hand(fiveOf(Clubs), fiveOf(Diamonds), fourOf(Hearts), sixOf(Hearts), twoOf(Diamonds));
		PlayerRank expected = pair(new TwoCards(fiveOf(Clubs), fiveOf(Diamonds)), sixOf(Hearts));

		//when
		final PlayerRank actual = ruleUnderTest.apply(hand);

		//then
		assertThat(actual).isEqualTo(expected);
	}
}
