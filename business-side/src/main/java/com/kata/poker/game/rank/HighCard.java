package com.kata.poker.game.rank;

import java.text.MessageFormat;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.enums.Value;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@EqualsAndHashCode
@Getter
public final class HighCard extends PlayerRank {

	HighCard(int priority, Card highestCard) {

		super(priority, highestCard);
	}

	public Value getValue() {

		return highestCard.getValue();
	}

	@Override
	public String display() {

		return MessageFormat.format("high card: {0}", formatCardValue(getValue()));
	}

}
