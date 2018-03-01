/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import java.util.List;

/**
 * Marks an object which defines the rules for what players may do during their turn and how those actions are translated to actions which affect the state of the game.
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
public interface TurnEngine<
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
     * Supplies the initial state of the of the given player's turn using the given state of the game.
     * @param actingPlayer The player who's turn will be played
     * @param initialState The state of the game at the beginning of the given player's turn
     * @return The initial state of the given player's turn
     */
    public TS getInitialTurnStateForAt(P actingPlayer, GS initialState);

    /**
     * Supplies a collection of the game actions which need to be applied to a game's state as the result of the turn's actions
     * @return A collection of game actions to be made to a game's state
     * @throws GameActionCreationException Thrown when an error occurs when converting the turn's state into actions in the game.
     */
    public List<GA> convertToGameActions(TS turnState) throws GameActionCreationException;

    /**
     * Applies the given action to the state and returns the state which resulted from applying the action
     *
     * Note: It is assumed that this method creates a new state object instead of simply modifying {@param originalState}.
     *
     * @param action The action to be performed
     * @param originalState The state of the player's turn before the action is applied
     * @return The state of the player's after the action is applied
     * @throws TurnActionException Thrown when an error occurs when applying the supplied action the the turn's state
     */
    public TS getTurnStateAfter(TA action, TS originalState) throws TurnActionException;
}
