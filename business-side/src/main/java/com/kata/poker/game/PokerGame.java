package com.kata.poker.game;


import com.kata.poker.ports.GameRulesAdapter;
import com.kata.poker.game.rank.PlayerRank;
import com.kata.poker.game.result.GameResult;
import com.kata.poker.game.result.Tie;
import com.kata.poker.game.result.Winner;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PokerGame {

	protected static final Tie TIE = new Tie();

	@NonNull
	private final GameRulesAdapter gameRulesAdapter;

	GameResult play(Player firstPlayer, Player secondPlayer) {

		PlayerRank firstPlayerPlayerRank = gameRulesAdapter.evaluate(firstPlayer.getHand());
		PlayerRank secondPlayerPlayerRank = gameRulesAdapter.evaluate(secondPlayer.getHand());

		final GameResult gameResult;

		if (firstPlayerPlayerRank.isHigherThan(secondPlayerPlayerRank)) {
			gameResult = new Winner(firstPlayer, firstPlayerPlayerRank);
		}
		else if (secondPlayerPlayerRank.isHigherThan(firstPlayerPlayerRank)) {
			gameResult = new Winner(secondPlayer, secondPlayerPlayerRank);
		}
		else {
			gameResult = TIE;
		}

		return gameResult;
	}
}
