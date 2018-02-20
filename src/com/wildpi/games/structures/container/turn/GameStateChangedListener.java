/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * Marks an object which will be notified when the a game's state has changed.
 *
 * @param <GA> The types of actions which may be applied to achieve a change in the state of the game
 * @param <GE> The type of object used to define the rules which govern the game
 * @param <GS> The type of object which represents the state of the overall game
 * @param <P>  The type of object which describes an actor playing the game
 * @param <PS> The type of object which describes the standing or rank of a {@link Player}
 * @param <TA> The types of actions which a {@link Player} may take during their turn (may be different than game actions {@param <GA>})
 * @param <TE> The typeof object used to define the rules which govern how {@link Player}s take their turns
 * @param <TS> The type of object which represents the state of a {@link Player}'s turn
 *
 * @author Alex
 */
public interface GameStateChangedListener<
        GA,
        GE extends GameEngine<GA, GE, GS, P, PS, TA, TE, TS>,
        GS,
        P extends Player<GA, GE, GS, P, PS, TA, TE, TS>,
        PS extends PlayerStanding<PS>,
        TA,
        TE extends TurnEngine<GA, GE, GS, P, PS, TA, TE, TS>,
        TS>
{
    /**
     * Called after a {@link Player}'s turn has changed the state of the game.
     *
     * Note: This may not be called for every action which results from a player's turn.
     *
     * @param previousState The state of the game before the action was taken
     * @param currentState  The state of the game after the action was taken
     * @param actingPlayer  The player on whose behalf the action was performed
     */
    public void onGameStateChangedBy(GS previousState, GS currentState, P actingPlayer);
}
