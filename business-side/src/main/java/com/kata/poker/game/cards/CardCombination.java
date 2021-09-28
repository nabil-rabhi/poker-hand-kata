package com.kata.poker.game.cards;

import java.util.*;

import com.kata.poker.game.cards.enums.Suit;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public final class CardCombination {

	private final List<Card> cards;

	public Set<Suit> allSuits() {

		return cards.stream().map(Card::getSuit).collect(toSet());
	}

	public Optional<List<Card>> selectCardsWithTheSameValue(int groupSize) {

		return groupBySize(groupSize).map(cardList -> cardList.subList(0, groupSize));
	}

	public Card highestCard() {

		return cards.stream().max(Card::compareTo).orElse(null);
	}

	public CardCombination allExcept(Card... cardsToExclude) {

		List<Card> remainingCards = cards.stream()
		                                 .filter(card -> !asList(cardsToExclude).contains(card))
		                                 .collect(toList());

		return new CardCombination(remainingCards);
	}

	public boolean hasAllCardsWithConsecutiveValues() {

		List<Card> cardList = new ArrayList<>(cards);
		cardList.sort(Card::compareTo);

		for(int cardIndex = 1; cardIndex < cardList.size(); cardIndex++) {
			if (!cardList.get(cardIndex - 1).doesComeBefore(cardList.get(cardIndex))) {
				return false;
			}
		}

		return true;
	}

	public int size() {

		return cards.size();
	}

	private Optional<List<Card>> groupBySize(int groupSize) {

		return cardValues().stream().filter(cardList -> cardList.size() >= groupSize).findFirst();
	}

	private Collection<List<Card>> cardValues() {

		return cards.stream().collect(groupingBy(Card::getValue)).values();
	}

}
