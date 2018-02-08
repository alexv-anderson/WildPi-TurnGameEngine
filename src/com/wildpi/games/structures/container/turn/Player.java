/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * Marks a object which can play a turn-based game.
 *
 * @param <A> The type of actions which the player can take
 * @param <E> The type of game engine provided to the player
 * @param <P> The type of players in the game
 * @param <S> The type of game states provided to the player
 *
 * @author Alex
 */
public interface Player<A, E extends GameEngine<A, E, P, S>, P extends Player<A, E, P, S>, S>
{
    /**
     * Called when it is this players turn to act in the game.
     *
     * @param currentState The current state of the game
     * @param gameEngine   The game engine which defines the rules and behavior of the game
     * @return The action which this player would like to perform
     */
    public A takeTurn(S currentState, E gameEngine);
}
