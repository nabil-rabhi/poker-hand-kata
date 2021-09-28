package com.kata.poker.input;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class InputHolder {

	private final String playerName;
	private final List<String> cardInput;
}
