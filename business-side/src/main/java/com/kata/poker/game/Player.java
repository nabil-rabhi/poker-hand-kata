package com.kata.poker.game;

import com.kata.poker.game.cards.Hand;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Player {

	private final String name;
	private final Hand hand;

}
