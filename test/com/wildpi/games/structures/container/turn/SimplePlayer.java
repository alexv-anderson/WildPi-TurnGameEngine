/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * @author Alex
 */
class SimplePlayer implements Player<
        SimpleGameEngine.SimpleAction,
        SimpleGameEngine,
        SimpleGameEngine.SimpleState,
        SimplePlayer,
        SimpleTurnEngine.Action,
        SimpleTurnEngine,
        SimpleTurnEngine.State>
{
    @Override
    public SimpleTurnEngine.State takeTurn(SimpleTurnEngine.State turnState, SimpleTurnEngine turnEngine, SimpleGameEngine.SimpleState gameState, SimpleGameEngine gameEngine)
    {
        return SimpleTurnEngine.State.A;
    }
}
