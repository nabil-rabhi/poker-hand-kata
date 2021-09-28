package com.kata.poker.adapters;

import java.util.List;

import com.kata.poker.game.Player;
import com.kata.poker.input.HandParser;
import com.kata.poker.input.InputHolder;
import com.kata.poker.ports.PlayerAdapter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class ConsolePlayerAdapterImpl implements PlayerAdapter {

	@NonNull
	private final InputHolder firstInputHolder;

	@NonNull
	private final InputHolder secondIputHolder;

	@NonNull
	private final HandParser handParser;

	@Override
	public Player getFirstPlayer() {

		return getPlayer(firstInputHolder);
	}

	@Override
	public Player getSecondPlayer() {

		return getPlayer(secondIputHolder);
	}

	private Player getPlayer(final InputHolder inputHolder) {

		final List<String> cardInput = inputHolder.getCardInput();
		return new Player(inputHolder.getPlayerName(), handParser.parse(cardInput));
	}
}
