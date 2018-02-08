/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * Marks an object which will be notified when an action is taken in a game.
 *
 * @param <A> The type of actions which the players can take
 * @param <E> The type of game engine provided to the players
 * @param <P> The type of players in the game
 * @param <S> The type of game states provided to the players
 *
 * @author Alex
 */
public interface GameActionListener<A, E extends GameEngine<A, E, P, S>, P extends Player<A, E, P, S>, S>
{
    /**
     * Called after an action has been taken in a game
     *
     * @param previousState The state of the game before the action was taken
     * @param currentState  The state of the game after the action was taken
     * @param actionTaken   The action which was taken
     * @param actingPlayer  The player on whose behalf the action was performed
     */
    public void onGameAction(S previousState, S currentState, A actionTaken, P actingPlayer);
}
