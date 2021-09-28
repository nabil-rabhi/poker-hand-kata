package com.kata.poker.game.result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TieTest {

	@Test
	public void getMessage_should_returnExpectedMessage() {

		//given
		GameResult tie = new Tie();
		final String expected = "Tie.";

		//when
		final String actual = tie.getMessage();

		//then
		Assertions.assertThat(actual).isEqualTo(expected);
	}
}
