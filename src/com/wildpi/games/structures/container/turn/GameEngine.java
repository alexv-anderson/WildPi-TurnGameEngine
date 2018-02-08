/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import java.util.Collection;
import java.util.List;

/**
 * Marks an object which defines the rules of the game.
 *
 * @param <A> The type of actions which the players can take
 * @param <E> The type of game engine provided to the players
 * @param <P> The type of players in the game
 * @param <S> The type of game states provided to the players
 *
 * @author Alex
 */
public interface GameEngine<A, E extends GameEngine<A, E, P, S>, P extends Player<A, E, P, S>, S>
{
    /**
     * Supplies a list of possible actions which are available to the given {@param actingPlayer} when the game is in the given {@param currentState}.
     *
     * @param actingPlayer The player who would be initiating the action
     * @param currentState The current state of the game
     * @return A list of possible actions
     */
    public List<A> getPossibleActionsForAt(P actingPlayer, S currentState);

    /**
     * Supplies the state which results from {@param actingPlayer} performing the given {@param action} at the {@param currentState}.
     *
     * Note: It is assumed that this method creates a new state object instead of simply modifying {@param currentState}.
     *
     * @param action       The action to be performed
     * @param actingPlayer The player who is initiating this action
     * @param currentState The state from which the action is to be taken
     * @return The state which results from taking the action
     */
    public S applyActionByAt(A action, P actingPlayer, S currentState);

    /**
     * Supplies a ranking of the provided {@param players} at the given {@param currentState} in order from winner to loser.
     *
     * @param players      The players to be ranked
     * @param currentState The state from which to calculate the rankings
     * @return A ranked list of the provided players
     */
    public List<P> rankPlayersAt(Collection<P> players, S currentState);

    /**
     * Indicates if the given state is one where the game is done
     *
     * @param currentState The state of the game
     * @return True if the game is completed; otherwise, false.
     */
    public boolean isGameCompletedAt(S currentState);
}
