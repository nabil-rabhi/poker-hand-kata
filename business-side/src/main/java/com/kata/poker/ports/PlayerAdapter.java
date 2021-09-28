package com.kata.poker.ports;


import com.kata.poker.game.Player;

public interface PlayerAdapter {

	Player getFirstPlayer();

	Player getSecondPlayer();
}
