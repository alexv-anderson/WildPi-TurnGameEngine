/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * Marks a object which can play a turn-based game.
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
public interface Player<
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
     * Called when it is this player's turn to act in the game.
     * @param turnState  The initial state of the player's turn
     * @param turnEngine The engine which allows the player to take actions during its turn
     * @param gameState  The current state of the game
     * @param gameEngine The engine which defines the rules of the game
     * @return The ending state of the player's turn
     */
    public TS takeTurn(TS turnState, TE turnEngine, GS gameState, GE gameEngine);
}
