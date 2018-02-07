package games.structures.container.turn;

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
