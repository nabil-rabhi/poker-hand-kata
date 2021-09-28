package com.kata.poker.rules;


import com.kata.poker.game.cards.Hand;
import com.kata.poker.game.rank.PlayerRank;

public interface Rule {

	boolean canApply(Hand hand);

	PlayerRank apply(Hand hand);
}
