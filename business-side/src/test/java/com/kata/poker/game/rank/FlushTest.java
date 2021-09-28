package com.kata.poker.game.rank;

import org.junit.jupiter.api.Test;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.enums.Suit;
import com.kata.poker.utils.CardProvider;

import static org.assertj.core.api.Assertions.assertThat;

class FlushTest {

	@Test
	void highestCardValue_should_returnTheHighestCardValue() {

		//given
		final Card expected = CardProvider.sevenOf(Suit.Spades);
		Flush flush = new Flush(7, expected);

		//when
		final Card actual = flush.getHighestCard();

		//then
		assertThat(actual).isEqualTo(expected);

	}

	@Test
	void display_should_return_ExpectedMessage() {

		//given
		Flush flush = new Flush(7, CardProvider.sevenOf(Suit.Spades));
		String expected = "flush: 7-high";

		//when
		final String actual = flush.display();

		//then
		assertThat(actual).isEqualTo(expected);

	}
}
