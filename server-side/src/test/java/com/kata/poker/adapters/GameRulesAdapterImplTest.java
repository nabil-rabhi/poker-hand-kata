package com.kata.poker.adapters;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.rank.PlayerRank;
import com.kata.poker.ports.GameRulesAdapter;

import static com.kata.poker.game.cards.enums.Suit.Clubs;
import static com.kata.poker.game.cards.enums.Suit.Diamonds;
import static com.kata.poker.game.cards.enums.Suit.Hearts;
import static com.kata.poker.game.cards.enums.Suit.Spades;
import static com.kata.poker.game.rank.PlayerRank.*;
import static com.kata.poker.utils.CardProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

class GameRulesAdapterImplTest {

	private GameRulesAdapter gameRulesAdapter;

	@BeforeEach
	void setUp() {

		gameRulesAdapter = new GameRulesAdapterImpl();
	}

	@ParameterizedTest
	@MethodSource("expectedRankByHand")
	void evaluate_should_returnExpectedRank_givenHand(PlayerRank expected, Hand hand) {

		//when
		final PlayerRank actual = gameRulesAdapter.evaluate(hand);

		//then

		assertThat(actual.getHighestCard()).isEqualTo(expected.getHighestCard());
		assertThat(actual.getPriority()).isEqualTo(expected.getPriority());
	}

	@SuppressWarnings("unused")
	private static Stream<Arguments> expectedRankByHand() {

		return Stream.of(Arguments.of(highCard(sevenOf(Hearts)),
		                              aHandOf(threeOf(Clubs),
		                                      fiveOf(Diamonds),
		                                      sevenOf(Hearts),
		                                      sixOf(Hearts),
		                                      twoOf(Diamonds))),

		                 Arguments.of(pair(new TwoCards(fiveOf(Clubs), fiveOf(Diamonds)), sixOf(Hearts)),
		                              aHandOf(fiveOf(Clubs),
		                                      fiveOf(Diamonds),
		                                      fourOf(Hearts),
		                                      sixOf(Hearts),
		                                      twoOf(Diamonds))),

		                 Arguments.of(twoPair(new TwoCards(fiveOf(Hearts), fiveOf(Diamonds)),
		                                      new TwoCards(threeOf(Clubs), threeOf(Hearts))),
		                              aHandOf(fiveOf(Hearts),
		                                      fiveOf(Diamonds),
		                                      threeOf(Clubs),
		                                      threeOf(Hearts),
		                                      twoOf(Diamonds))),

		                 Arguments.of(threeOfKind(fiveOf(Diamonds)),
		                              aHandOf(fiveOf(Diamonds),
		                                      fiveOf(Hearts),
		                                      fiveOf(Clubs),
		                                      fourOf(Clubs),
		                                      sixOf(Hearts))),

		                 Arguments.of(straight(sixOf(Hearts)),
		                              aHandOf(twoOf(Diamonds),
		                                      threeOf(Clubs),
		                                      fourOf(Diamonds),
		                                      fiveOf(Hearts),
		                                      sixOf(Hearts))),

		                 Arguments.of(fullHouse(queenOf(Hearts), new TwoCards(threeOf(Clubs), threeOf(Diamonds))),
		                              aHandOf(threeOf(Clubs),
		                                      threeOf(Diamonds),
		                                      queenOf(Hearts),
		                                      queenOf(Diamonds),
		                                      queenOf(Spades))),

		                 Arguments.of(fourOfKind(fiveOf(Diamonds)),
		                              aHandOf(fiveOf(Diamonds),
		                                      fiveOf(Hearts),
		                                      fiveOf(Clubs),
		                                      fiveOf(Clubs),
		                                      sixOf(Hearts))),

		                 Arguments.of(straightFlush(sixOf(Clubs)),
		                              aHandOf(twoOf(Clubs),
		                                      threeOf(Clubs),
		                                      fourOf(Clubs),
		                                      fiveOf(Clubs),
		                                      sixOf(Clubs)))
		);
	}

	private static Hand aHandOf(Card... cards) {

		return new Hand(cards);
	}
}
