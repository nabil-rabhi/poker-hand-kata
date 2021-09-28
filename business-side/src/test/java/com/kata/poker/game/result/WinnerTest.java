package com.kata.poker.game.result;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.kata.poker.game.Player;
import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.rank.PlayerRank;

import static com.kata.poker.game.cards.enums.Suit.Clubs;
import static com.kata.poker.game.cards.enums.Suit.Diamonds;
import static com.kata.poker.game.cards.enums.Suit.Hearts;
import static com.kata.poker.game.cards.enums.Suit.Spades;
import static com.kata.poker.game.rank.PlayerRank.*;
import static com.kata.poker.utils.CardProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

	@ParameterizedTest
	@MethodSource("expectedMessageByPlayerNameCardCombinations")
	public void getMessage_should_returnExpectedMessage_givenCardCombinaiton(Winner winner, String expected) {

		//when
		final String actual = winner.getMessage();

		//then
		assertThat(actual).isEqualTo(expected);
	}

	@SuppressWarnings("unused")
	private static Stream<Arguments> expectedMessageByPlayerNameCardCombinations() {

		return Stream.of(Arguments.of(aWinnerWith(highCard(sevenOf(Hearts)),
		                                          threeOf(Clubs),
		                                          fiveOf(Diamonds),
		                                          sevenOf(Hearts),
		                                          sixOf(Hearts),
		                                          twoOf(Diamonds)), "Black wins. - with high card: 7"),

		                 Arguments.of(aWinnerWith(highCard(jackOf(Hearts)),
		                                          jackOf(Hearts),
		                                          threeOf(Clubs),
		                                          fiveOf(Diamonds),
		                                          sixOf(Hearts),
		                                          twoOf(Diamonds)), "Black wins. - with high card: Jack"),

		                 Arguments.of(aWinnerWith(highCard(kingOf(Hearts)),
		                                          kingOf(Hearts),
		                                          threeOf(Clubs),
		                                          fiveOf(Diamonds),
		                                          sixOf(Hearts),
		                                          twoOf(Diamonds)), "Black wins. - with high card: King"),

		                 Arguments.of(aWinnerWith(highCard(queenOf(Hearts)),
		                                          queenOf(Hearts),
		                                          threeOf(Clubs),
		                                          fiveOf(Diamonds),
		                                          sixOf(Hearts),
		                                          twoOf(Diamonds)), "Black wins. - with high card: Queen"),

		                 Arguments.of(aWinnerWith(highCard(aceOf(Hearts)),
		                                          aceOf(Hearts),
		                                          threeOf(Clubs),
		                                          fiveOf(Diamonds),
		                                          sixOf(Hearts),
		                                          twoOf(Diamonds)), "Black wins. - with high card: Ace"),

		                 Arguments.of(aWinnerWith(pair(new TwoCards(fiveOf(Clubs), fiveOf(Diamonds)), sixOf(Hearts)),
		                                          fiveOf(Clubs),
		                                          fiveOf(Diamonds),
		                                          fourOf(Hearts),
		                                          sixOf(Hearts),
		                                          twoOf(Diamonds)), "Black wins. - with pair: 5s"),

		                 Arguments.of(aWinnerWith(twoPair(new TwoCards(fiveOf(Hearts), fiveOf(Diamonds)),
		                                                  new TwoCards(threeOf(Clubs), threeOf(Hearts))),
		                                          fiveOf(Hearts),
		                                          fiveOf(Diamonds),
		                                          threeOf(Clubs),
		                                          threeOf(Hearts),
		                                          twoOf(Diamonds)), "Black wins. - with two pairs: 5s and 3s"),

		                 Arguments.of(aWinnerWith(threeOfKind(fiveOf(Diamonds)),
		                                          fiveOf(Diamonds),
		                                          fiveOf(Hearts),
		                                          fiveOf(Clubs),
		                                          fourOf(Clubs),
		                                          sixOf(Hearts)), "Black wins. - with three of a kind: 5s"),

		                 Arguments.of(aWinnerWith(straight(sixOf(Hearts)),
		                                          twoOf(Diamonds),
		                                          threeOf(Clubs),
		                                          fourOf(Diamonds),
		                                          fiveOf(Hearts),
		                                          sixOf(Hearts)), "Black wins. - with straight: 6-high"),

		                 Arguments.of(aWinnerWith(flush(jackOf(Hearts)),
		                                          fiveOf(Hearts),
		                                          sevenOf(Hearts),
		                                          threeOf(Hearts),
		                                          twoOf(Hearts),
		                                          jackOf(Hearts)), "Black wins. - with flush: Jack-high"),

		                 Arguments.of(aWinnerWith(fullHouse(queenOf(Hearts),
		                                                    new TwoCards(threeOf(Clubs), threeOf(Diamonds))),
		                                          threeOf(Clubs),
		                                          threeOf(Diamonds),
		                                          queenOf(Hearts),
		                                          queenOf(Diamonds),
		                                          queenOf(Spades)), "Black wins. - with full house: Queen over 3"),

		                 Arguments.of(aWinnerWith(fourOfKind(fiveOf(Diamonds)),
		                                          fiveOf(Diamonds),
		                                          fiveOf(Hearts),
		                                          fiveOf(Clubs),
		                                          fiveOf(Clubs),
		                                          sixOf(Hearts)), "Black wins. - with four of a kind: 5s"),

		                 Arguments.of(aWinnerWith(straightFlush(sixOf(Clubs)),
		                                          twoOf(Clubs),
		                                          threeOf(Clubs),
		                                          fourOf(Clubs),
		                                          fiveOf(Clubs),
		                                          sixOf(Clubs)), "Black wins. - with straight flush: 6-high")

		);

	}

	private static Winner aWinnerWith(PlayerRank playerRank, Card... cards) {

		Player player = Player.builder().name("Black").hand(new Hand(cards)).build();
		return Winner.builder().player(player).playerRank(playerRank).build();
	}

}

