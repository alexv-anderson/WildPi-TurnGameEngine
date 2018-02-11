/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import java.util.*;

/**
 * @author Alex
 */
class SimpleGameEngine implements GameEngine<
        SimpleGameEngine.SimpleAction,
        SimpleGameEngine,
        SimpleGameEngine.SimpleState,
        SimplePlayer,
        SimpleTurnEngine.Action,
        SimpleTurnEngine,
        SimpleTurnEngine.State>
{
//    @Override
//    public List<SimpleAction> getPossibleActionsForAt(SimplePlayer actingPlayer, SimpleState currentState)
//    {
//        return Arrays.asList(SimpleAction.values());
//    }
//
//    @Override
//    public SimpleState applyActionByAt(SimpleAction action, SimplePlayer actingPlayer, SimpleState currentState)
//    {
//        switch(currentState) {
//            case FULL:
//            case HALF:
//                return SimpleState.FULL;
//            case EMPTY:
//                return SimpleState.HALF;
//        }
//
//        return SimpleState.EMPTY;
//    }

    @Override
    public SimpleState getGameStateAfterTurn(SimpleTurnEngine.State endTurnState, SimplePlayer actingPlayer, SimpleState originalState)
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
    public List<SimplePlayer> rankPlayersAt(Collection<SimplePlayer> players, SimpleState currentState)
    {
        return new ArrayList<>(players);
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
