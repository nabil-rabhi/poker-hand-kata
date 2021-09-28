package com.kata.poker.game.rank;

import com.kata.poker.game.cards.Card;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.cards.enums.Value;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import static com.kata.poker.game.cards.enums.Value.ACE;
import static com.kata.poker.game.cards.enums.Value.JACK;
import static com.kata.poker.game.cards.enums.Value.KING;
import static com.kata.poker.game.cards.enums.Value.QUEEN;


@EqualsAndHashCode
@Getter
public abstract class PlayerRank implements Comparable<PlayerRank> {

	protected final int priority;
	protected final Card highestCard;

	PlayerRank(int priority, Card highestCard) {

		this.priority = priority;
		this.highestCard = highestCard;
	}

	public static PlayerRank highCard(Card highestCard) {

		return new HighCard(1, highestCard);
	}

	public static PlayerRank pair(TwoCards twoCards, Card highestRankingCard) {

		return new Pair(2, twoCards, highestRankingCard);
	}

	public static PlayerRank twoPair(TwoCards firstPair, TwoCards secondPair) {

		Card highestPairCard = getHighestCardFrom(firstPair, secondPair);
		return new TwoPair(3, highestPairCard, firstPair, secondPair);
	}

	public static PlayerRank threeOfKind(Card card) {

		return new ThreeOfKind(4, card);
	}

	public static PlayerRank straight(Card highestCard) {

		return new Straight(5, highestCard);
	}

	public static PlayerRank flush(Card highestCard) {

		return new Flush(6, highestCard);
	}

	public static PlayerRank fullHouse(final Card highestCard, final TwoCards twoCards) {

		return new FullHouse(7, highestCard, twoCards);
	}

	public static PlayerRank fourOfKind(Card highestCard) {

		return new FourOfKind(8, highestCard);
	}

	public static PlayerRank straightFlush(Card highestCard) {

		return new StraightFlush(9, highestCard);
	}

	private static Card getHighestCardFrom(TwoCards firstPair, TwoCards secondPair) {

		final Card firstCardInTheFirstPair = firstPair.getFirst();
		final Card firstCardInTheSecondPair = secondPair.getFirst();

		final Value highestCardValue = Value.max(firstCardInTheFirstPair.getValue(),
		                                         firstCardInTheSecondPair.getValue());

		if (firstCardInTheFirstPair.getValue() == highestCardValue) {
			return firstCardInTheFirstPair;
		}
		return firstCardInTheSecondPair;

	}

	public abstract String display();

	@Override
	public final int compareTo(PlayerRank playerRank) {

		return Integer.compare(priority, playerRank.priority);
	}

	protected final String formatCardValue(Value cardValue) {

		if (JACK == cardValue) {
			return "Jack";
		}
		if (QUEEN == cardValue) {
			return "Queen";
		}
		if (KING == cardValue) {
			return "King";
		}
		if (ACE == cardValue) {
			return "Ace";
		}

		return cardValue.numericValue.toString();
	}

	public boolean isHigherThan(PlayerRank anotherPalyerPlayerRank) {

		if (hasTheSamePriority(anotherPalyerPlayerRank)) {
			return highestCard.isHigherThan(anotherPalyerPlayerRank.highestCard);
		}

		return priority > anotherPalyerPlayerRank.priority;
	}

	private boolean hasTheSamePriority(final PlayerRank anotherPalyerPlayerRank) {

		return priority == anotherPalyerPlayerRank.priority;
	}

	@Override
	public String toString() {

		return display();
	}
}
