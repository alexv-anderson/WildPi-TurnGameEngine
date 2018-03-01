/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * Represents exceptions which result from the execution of turn actions (see {@link TurnEngine#getTurnStateAfter}).
 *
 * @author Alex
 */
public class TurnActionException extends Exception
{
    public TurnActionException()
    {
    }

    public TurnActionException(String message)
    {
        super(message);
    }

    public TurnActionException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TurnActionException(Throwable cause)
    {
        super(cause);
    }
}
