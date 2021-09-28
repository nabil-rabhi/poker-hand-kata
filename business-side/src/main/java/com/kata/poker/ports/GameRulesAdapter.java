package com.kata.poker.ports;


import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

@FunctionalInterface
public interface GameRulesAdapter {

	PlayerRank evaluate(Hand hand);
}
