package com.kata.poker.game.result;

import java.text.MessageFormat;

import com.kata.poker.game.Player;
import com.kata.poker.game.rank.PlayerRank;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@Builder
public class Winner implements GameResult {

	private final Player player;
	private final PlayerRank playerRank;

	@Override
	public String getMessage() {

		return MessageFormat.format("{0} wins. - with {1}", player.getName(), playerRank.display());
	}

	@Override
	public String toString() {

		return getMessage();
	}
}
