package com.kata.poker.game.rank;

import java.text.MessageFormat;

import com.kata.poker.game.cards.Card;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class FourOfKind extends PlayerRank {

	public FourOfKind(int priority, Card highestCard) {

		super(priority, highestCard);
	}

	@Override
	public String display() {

		return MessageFormat.format("four of a kind: {0}s",
		                            formatCardValue(highestCard.getValue()));
	}


}
