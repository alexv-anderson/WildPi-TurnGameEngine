/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * Marks an object which describes the standing or rank of a {@link Player}
 *
 * @param <PS> The type of object which describes the standing or rank of a {@link Player}
 * @author Alex
 */
public interface PlayerStanding<PS extends PlayerStanding<PS>> extends Comparable<PS>
{
}
