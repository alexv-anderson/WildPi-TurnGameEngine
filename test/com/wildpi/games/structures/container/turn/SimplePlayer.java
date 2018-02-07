/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

class SimplePlayer implements Player<SimpleAction, SimpleGameEngine, SimplePlayer, SimpleState>
{
    @Override
    public SimpleAction takeTurn(SimpleState currentState, SimpleGameEngine gameEngine)
    {
        if(gameEngine.getPossibleActionsForAt(this, currentState).contains(SimpleAction.POUR))
            return SimpleAction.POUR;

        return SimpleAction.NOTHING;
    }
}
