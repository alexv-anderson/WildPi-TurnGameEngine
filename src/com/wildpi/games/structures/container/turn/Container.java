/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import java.util.List;

/**
 * Marks an object which holds the various objects needed to play a game
 *
 * @param <GA> The types of actions which may be applied to achieve a change in the state of the game
 * @param <GE> The type of object used to define the rules which govern the game
 * @param <GS> The type of object which represents the state of the overall game
 * @param <P>  The type of object which describes an actor playing the game
 * @param <TA> The types of actions which a {@link Player} may take during their turn (may be different than game actions {@param <GA>})
 * @param <TE> The typeof object used to define the rules which govern how {@link Player}s take their turns
 * @param <TS> The type of object which represents the state of a {@link Player}'s turn
 *
 * @author Alex
 */
public interface Container<
        GA,
        GE extends GameEngine<GA, GE, GS, P, TA, TE, TS>,
        GS,
        P extends Player<GA, GE, GS, P, TA, TE, TS>,
        TA,
        TE extends TurnEngine<GA, GE, GS, P, TA, TE, TS>,
        TS>
{
    /**
     * Plays the game
     */
    public void playGame();

    /**
     * Supplies the state in which the game will start
     * @return The game's start state
     */
    public GS getStartState();

    /**
     * Sets the state in which the game will start to the given state
     * @param startState The state in which the game will start
     */
    public void setStartState(GS startState);

    /**
     * Adds the given {@link GameStateChangedListener} to this {@link Container}
     * @param listener The listener to be added
     */
    public void addGameActionListener(GameStateChangedListener<GA, GE, GS, P, TA, TE, TS> listener);

    /**
     * Supplies a ranking of all the players in the game in order from winner to loser
     * //TODO: Adjust to allow for tie games
     * @return A ranked list of the players
     */
    public List<P> getPlayerRanking();
}
