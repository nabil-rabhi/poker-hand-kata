package com.kata.poker.game.cards;

import java.util.*;

import com.kata.poker.game.cards.combinations.FourCards;
import com.kata.poker.game.cards.combinations.ThreeCards;
import com.kata.poker.game.cards.combinations.TwoCards;
import com.kata.poker.game.cards.exceptions.FiveCardsExpectedException;
import com.kata.poker.game.cards.exceptions.InvalidCardCombinationException;

public final class Hand {

	private final CardCombination cardCombination;

	public Hand(Card... cards) {

		validate(cards);

		this.cardCombination = new CardCombination(Arrays.asList(cards));
	}

	public Hand(final CardCombination cardCombination) {

		this.cardCombination = cardCombination;

	}

	private void validate(Card... cards) {

		int numberOfCards = cards.length;

		if (numberOfCards != 5) {
			throw new FiveCardsExpectedException(numberOfCards);
		}

		if (atLeastFourCardsAreIdentical(cards)) {
			throw new InvalidCardCombinationException("card combination is not valid: " + Arrays.toString(cards));
		}
	}

	private boolean atLeastFourCardsAreIdentical(final Card... cards) {

		Collection<Card> cardSet = new HashSet<>(Arrays.asList(cards));
		return cardSet.size() <= 2;
	}

	public Card highestCard() {

		return cardCombination.highestCard();
	}

	public boolean hasAllCardsWithConsecutiveValues() {

		return cardCombination.hasAllCardsWithConsecutiveValues();
	}

	public boolean hasAllCardsWithTheSameSuit() {

		return cardCombination.allSuits().size() == 1;
	}

	public boolean hasTwoCardsWithTheSameValue() {

		return selectTwoCardsWithTheSameValue().isPresent();
	}

	public boolean hasThreeCardsWithTheSameValue() {

		return selectThreeCardsWithTheSameValue().isPresent();
	}

	public boolean hasFourCardsWithTheSameValue() {

		return selectFourCardsWithTheSameValue().isPresent();
	}

	public CardCombination allCardsExcept(Card... cardsToExclude) {

		return cardCombination.allExcept(cardsToExclude);
	}

	public Optional<List<TwoCards>> selectCoupleOfTwoCardsWithTheSameValue() {

		List<TwoCards> twoPair = new ArrayList<>();
		CardCombination remainingCardCombination = cardCombination;

		while(remainingCardCombination.size() >= 2) {
			if (remainingCardCombination.selectCardsWithTheSameValue(2).isEmpty()) {
				return Optional.empty();
			}

			List<Card> pairCards = remainingCardCombination.selectCardsWithTheSameValue(2).get();

			TwoCards twoCards = new TwoCards(pairCards.get(0), pairCards.get(1));
			twoPair.add(twoCards);

			remainingCardCombination = remainingCardCombination.allExcept(twoCards.getFirst(), twoCards.getSecond());
		}

		return Optional.of(twoPair);
	}

	public Optional<TwoCards> selectTwoCardsWithTheSameValue() {

		return cardCombination.selectCardsWithTheSameValue(2).map(cards -> new TwoCards(cards.get(0), cards.get(1)));
	}

	public Optional<ThreeCards> selectThreeCardsWithTheSameValue() {

		return cardCombination.selectCardsWithTheSameValue(3)
		                      .map(cards -> new ThreeCards(cards.get(0), cards.get(1), cards.get(2)));
	}

	public Optional<FourCards> selectFourCardsWithTheSameValue() {

		return cardCombination.selectCardsWithTheSameValue(4)
		                      .map(cards -> new FourCards(cards.get(0), cards.get(1), cards.get(2), cards.get(3)));
	}

	@Override
	public String toString() {

		return cardCombination.toString();
	}
}
