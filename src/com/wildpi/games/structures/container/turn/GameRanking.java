/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * Marks an object which groups a player and a description of the player's standing/ranking in a game.
 *
 * @param <P>  The type of object which describes an actor playing the game
 * @param <PS> The type of object which describes the standing or rank of a {@link Player}
 *
 * @author Alex
 */
public interface GameRanking<P, PS>
{
    /**
     * Supplies the player which the standing/ranking defines
     * @return The player which has been ranked
     */
    public P getPlayer();

    /**
     * Supplies the standing/ranking of the player
     * @return The player's standing/ranking
     */
    public PS getPlayerStanding();
}
