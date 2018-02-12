/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import java.util.Collections;
import java.util.List;

public class SimpleTurnEngine implements TurnEngine<
        SimpleGameEngine.SimpleAction,
        SimpleGameEngine,
        SimpleGameEngine.SimpleState,
        SimplePlayer,
        SimpleTurnEngine.Action,
        SimpleTurnEngine,
        SimpleTurnEngine.State>
{
    @Override
    public State getInitialTurnStateForAt(SimplePlayer actingPlayer, SimpleGameEngine.SimpleState initialState)
    {
        return State.A;
    }

    @Override
    public List<SimpleGameEngine.SimpleAction> convertToGameActions(State turnState)
    {
        return Collections.singletonList(SimpleGameEngine.SimpleAction.POUR);
    }

    @Override
    public State getTurnStateAfter(Action action, State originalState)
    {
        return State.A;
    }

    enum State { A }
    enum Action { NOTHING }
}
