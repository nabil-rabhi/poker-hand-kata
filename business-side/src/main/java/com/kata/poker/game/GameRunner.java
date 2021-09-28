package com.kata.poker.game;

import com.kata.poker.game.result.GameResult;
import com.kata.poker.ports.PlayerAdapter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class GameRunner {

	@NonNull
	private final PlayerAdapter playerAdapter;

	@NonNull
	private final PokerGame pokerGame;

	public GameResult run() {

		Player firstPlayer = playerAdapter.getFirstPlayer();
		Player secondPlayer = playerAdapter.getSecondPlayer();

		return pokerGame.play(firstPlayer, secondPlayer);

	}

}
