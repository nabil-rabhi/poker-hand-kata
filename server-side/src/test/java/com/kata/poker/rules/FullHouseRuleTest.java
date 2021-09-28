package com.kata.poker.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.rank.PlayerRank;

import static com.kata.poker.game.cards.enums.Suit.Clubs;
import static com.kata.poker.game.cards.enums.Suit.Diamonds;
import static com.kata.poker.game.cards.enums.Suit.Hearts;
import static com.kata.poker.game.cards.enums.Suit.Spades;
import static com.kata.poker.game.rank.PlayerRank.fullHouse;
import static com.kata.poker.utils.CardProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

class FullHouseRuleTest {

	private Rule ruleUnderTest;

	@BeforeEach
	void setUp() {

		ruleUnderTest = new FullHouseRule(new ThreeOfKindRule(), new PairRule());
	}

	@Test
	void canApply_should_returnTrue_when_HandIsFullHouse() {

		//given
		Hand hand = new Hand(threeOf(Clubs), threeOf(Diamonds), queenOf(Hearts), queenOf(Diamonds), queenOf(Spades));

		//when
		final boolean result = ruleUnderTest.canApply(hand);

		//then
		assertThat(result).isTrue();
	}

	@Test
	void apply_should_returnFlushRank_when_handIsFullHouse() {

		//given
		Hand hand = new Hand(threeOf(Clubs), threeOf(Diamonds), queenOf(Hearts), queenOf(Diamonds), queenOf(Spades));
		PlayerRank expected = fullHouse(queenOf(Hearts), new TwoCards(threeOf(Clubs), threeOf(Diamonds)));

		//when
		final PlayerRank actual = ruleUnderTest.apply(hand);

		//then
		assertThat(actual).isEqualTo(expected);
	}
}
