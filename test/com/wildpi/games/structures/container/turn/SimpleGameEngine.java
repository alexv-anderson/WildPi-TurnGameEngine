/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * @author Alex
 */
class SimpleGameEngine implements GameEngine<
        SimpleGameEngine.SimpleAction,
        SimpleGameEngine,
        SimpleGameEngine.SimpleState,
        SimplePlayer,
        SimplePlayer.Standing,
        SimpleTurnEngine.Action,
        SimpleTurnEngine,
        SimpleTurnEngine.State>
{
    @Override
    public SimpleState getGameStateAfterActionBy(SimpleAction action, SimplePlayer actingPlayer, SimpleState originalState)
    {
        switch(originalState)
        {
            case FULL:
            case HALF:
                return SimpleState.FULL;
            case EMPTY:
                return SimpleState.HALF;
        }

        return SimpleState.EMPTY;
    }

    @Override
    public SimplePlayer.Standing getPlayerStandingForAt(SimplePlayer player, SimpleState currentState)
    {
        return new SimplePlayer.Standing(10);
    }

    @Override
    public boolean isGameCompletedAt(SimpleState currentState)
    {
        return currentState.equals(SimpleState.FULL);
    }

    /**
     * @author Alex
     */
    static enum SimpleAction
    {
        POUR, NOTHING
    }

    /**
     * @author Alex
     */
    static enum SimpleState
    {
        FULL, HALF, EMPTY
    }
}
