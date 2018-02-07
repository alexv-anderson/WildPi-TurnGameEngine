/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
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
    public A takeTurn(S currentState, E gameEngine);
}
