/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import java.util.Collection;
import java.util.List;

/**
 * Marks an object which defines the rules of the game.
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
public interface GameEngine<
        GA,
        GE extends GameEngine<GA, GE, GS, P, TA, TE, TS>,
        GS,
        P extends Player<GA, GE, GS, P, TA, TE, TS>,
        TA,
        TE extends TurnEngine<GA, GE, GS, P, TA, TE, TS>,
        TS>
{
    /**
     * Supplies the state which results from {@param actingPlayer} performing the given {@param action} at the {@param originalState}.
     *
     * Note: It is assumed that this method creates a new state object instead of simply modifying {@param originalState}.
     *
     * @param endTurnState  The end state of the given player's turn
     * @param actingPlayer  The player who has completed their turn
     * @param originalState The game state from which the action is to be taken
     * @return The game state which results from taking the action
     */
    public GS getGameStateAfterTurn(TS endTurnState, P actingPlayer, GS originalState);

    /**
     * Supplies a ranking of the provided {@param players} at the given {@param currentState} in order from winner to loser.
     *
     * @param players      The players to be ranked
     * @param currentState The state from which to calculate the rankings
     * @return A ranked list of the provided players
     */
    public List<P> rankPlayersAt(Collection<P> players, GS currentState);

    /**
     * Indicates if the given state is one where the game is done.
     *
     * @param currentState The state of the game
     * @return True if the game is completed; otherwise, false.
     */
    public boolean isGameCompletedAt(GS currentState);
}
