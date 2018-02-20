/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * Marks an object which defines the rules of the game.
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
public interface GameEngine<
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
     * Supplies the state which results from {@param actingPlayer} performing the given {@param action} on the {@param originalState}.
     *
     * Note: It is assumed that this method creates a new state object instead of simply modifying {@param originalState}.
     *
     * @param action        The game action which the given player's is performing
     * @param actingPlayer  The player who is performing the action
     * @param originalState The game state from which the action is to be performed
     * @return The game state which results from taking the action
     */
    public GS getGameStateAfterActionBy(GA action, P actingPlayer, GS originalState);

    /**
     * Supplies an object which describes the given player's standing/ranking in the game at the given state.
     *
     * @param player       The players to be ranked
     * @param currentState The state from which to calculate the rankings
     * @return The number of points for the given player
     */
    public PS getPlayerStandingForAt(P player, GS currentState);

    /**
     * Indicates if the given state is one where the game is done.
     *
     * @param currentState The state of the game
     * @return True if the game is completed; otherwise, false.
     */
    public boolean isGameCompletedAt(GS currentState);
}
