package com.kata.poker;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.kata.poker.adapters.ConsolePlayerAdapterImpl;
import com.kata.poker.adapters.GameRulesAdapterImpl;
import com.kata.poker.game.GameRunner;
import com.kata.poker.game.PokerGame;
import com.kata.poker.game.result.GameResult;
import com.kata.poker.input.CardParser;
import com.kata.poker.input.HandParser;
import com.kata.poker.input.InputHolder;
import com.kata.poker.ports.GameRulesAdapter;
import com.kata.poker.ports.PlayerAdapter;

public class Application {

	private static final Pattern PATTERN = Pattern.compile("^[2-9TJQKA][CDHS]$");

	public static void main(String... args) {

		PlayerAdapter playerAdapter = initPlayerAdapter();

		GameRulesAdapter gameRulesAdapter = new GameRulesAdapterImpl();

		PokerGame pokerGame = new PokerGame(gameRulesAdapter);

		GameRunner gameRunner = new GameRunner(playerAdapter, pokerGame);

		final GameResult result = gameRunner.run();
		System.out.println(result.getMessage());
	}

	private static PlayerAdapter initPlayerAdapter() {

		final CardParser cardParser = new CardParser();
		final HandParser handParser = new HandParser(cardParser);

		InputHolder firstInputHolder = null;
		InputHolder secondIputHolder = null;

		try(Scanner scanner = new Scanner(System.in)) {
			firstInputHolder = readInputFromConsole(scanner, 1);
			secondIputHolder = readInputFromConsole(scanner, 2);
		}

		return new ConsolePlayerAdapterImpl(firstInputHolder, secondIputHolder, handParser);
	}

	private static InputHolder readInputFromConsole(Scanner scanner, final int playerNumber) {

		String playerName = null;
		List<String> cardInput = new ArrayList<>();

		System.out.print(MessageFormat.format("Please enter player #{0} name: ", playerNumber));

		final String cardMessage = "Please enter card #{0}: ";

		if (scanner.hasNext()) {
			playerName = scanner.nextLine();

			for(int i = 0; i < 5; i++) {

				System.out.print(MessageFormat.format(cardMessage, i + 1));
				String input = scanner.nextLine();

				while(!PATTERN.matcher(input).matches()) {
					System.out.println(MessageFormat.format("[{0}] is not a valid card.", input));
					System.out.print(MessageFormat.format(cardMessage, i + 1));
					input = scanner.nextLine();
				}

				cardInput.add(input);
			}
		}

		return new InputHolder(playerName, cardInput);
	}
}
