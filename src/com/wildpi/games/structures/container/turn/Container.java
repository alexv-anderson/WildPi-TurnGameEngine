/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import java.util.List;

/**
 *
 * @param <A> The type of actions which the player can take
 * @param <E> The type of game engine provided to the player
 * @param <P> The type of players in the game
 * @param <S> The type of game states provided to the player
 *
 * @author Alex
 */
public interface Container<A, E extends GameEngine<A, E, P, S>, P extends Player<A, E, P, S>, S>
{
    public void playGame();

    public S getStartState();
    public void setStartState(S startState);

    public void addGameStateChangeListener(GameStateChangeListener<A, E, P, S> listener);

    public List<P> getPlayerRanking();
}
