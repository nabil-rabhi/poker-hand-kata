package com.kata.poker.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.rank.PlayerRank;

import static com.kata.poker.game.cards.enums.Suit.Clubs;
import static com.kata.poker.game.cards.enums.Suit.Diamonds;
import static com.kata.poker.game.cards.enums.Suit.Hearts;
import static com.kata.poker.game.rank.PlayerRank.twoPair;
import static com.kata.poker.utils.CardProvider.fiveOf;
import static com.kata.poker.utils.CardProvider.threeOf;
import static com.kata.poker.utils.CardProvider.twoOf;
import static org.assertj.core.api.Assertions.assertThat;

class TwoPairRuleTest {

	private Rule ruleUnderTest;

	@BeforeEach
	void setUp() {

		ruleUnderTest = new TwoPairRule();
	}

	@Test
	void canApply_should_returnTrue_when_HandHasTwoPairs() {

		//given
		Hand hand = new Hand(fiveOf(Hearts), fiveOf(Diamonds), threeOf(Clubs), threeOf(Hearts), twoOf(Diamonds));

		//when
		final boolean result = ruleUnderTest.canApply(hand);

		//then
		assertThat(result).isTrue();
	}

	@Test
	void apply_should_returnFlushRank_when_handHasTwoPairs() {

		//given
		Hand hand = new Hand(fiveOf(Hearts), fiveOf(Diamonds), threeOf(Clubs), threeOf(Hearts), twoOf(Diamonds));
		PlayerRank expected = twoPair(new TwoCards(fiveOf(Hearts), fiveOf(Diamonds)),
		                              new TwoCards(threeOf(Clubs), threeOf(Hearts)));

		//when
		final PlayerRank actual = ruleUnderTest.apply(hand);

		//then
		assertThat(actual).isEqualTo(expected);
	}
}
