package games.structures.container.turn;

import java.util.Arrays;
import java.util.List;

class SimpleGameEngine implements GameEngine<SimpleAction, SimpleGameEngine, SimplePlayer, SimpleState>
{
    @Override
    public List<SimpleAction> getPossibleActionsForAt(SimplePlayer actingPlayer, SimpleState currentState)
    {
        return Arrays.asList(SimpleAction.values());
    }

    @Override
    public SimpleState applyActionByAt(SimpleAction action, SimplePlayer actingPlayer, SimpleState currentState)
    {
        switch(currentState) {
            case FULL:
            case HALF:
                return SimpleState.FULL;
            case EMPTY:
                return SimpleState.HALF;
        }

        return SimpleState.EMPTY;
    }

    @Override
    public boolean isGameCompletedAt(SimpleState currentState)
    {
        return currentState.equals(SimpleState.FULL);
    }
}