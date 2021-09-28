package com.kata.poker.game.rank;

import java.text.MessageFormat;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.combinations.TwoCards;

public class FullHouse extends PlayerRank {

	private final TwoCards twoCards;

	public FullHouse(int priority,
	                 Card highestCard,
	                 TwoCards twoCards) {

		super(priority, highestCard);

		this.twoCards = twoCards;
	}

	@Override
	public String display() {

		return MessageFormat.format("full house: {0} over {1}",
		                            formatCardValue(highestCard.getValue()),
		                            formatCardValue(twoCards.getFirst().getValue()));
	}
}
