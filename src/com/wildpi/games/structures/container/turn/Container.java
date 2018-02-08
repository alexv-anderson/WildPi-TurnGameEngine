/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import java.util.List;

/**
 * Marks an object which holds the various objects needed to play a game
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
    /**
     * Plays the game
     */
    public void playGame();

    /**
     * Supplies the state in which the game will start
     * @return The game's start state
     */
    public S getStartState();

    /**
     * Sets the state in which the game will start to the given state
     * @param startState The state in which the game will start
     */
    public void setStartState(S startState);

    /**
     * Adds the given {@link GameActionListener} to this {@link Container}
     * @param listener
     */
    public void addGameActionListener(GameActionListener<A, E, P, S> listener);

    /**
     * Supplies a ranking of all the players in the game in order from winner to loser
     * //TODO: Adjust to allow for tie games
     * @return A ranked list of the players
     */
    public List<P> getPlayerRanking();
}
