/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * Represents exceptions which result from creating game actions (see {@link TurnEngine#convertToGameActions}).
 *
 * @author Alex
 */
public class GameActionCreationException extends Exception
{
    public GameActionCreationException()
    {
    }

    public GameActionCreationException(String message)
    {
        super(message);
    }

    public GameActionCreationException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public GameActionCreationException(Throwable cause)
    {
        super(cause);
    }
}
