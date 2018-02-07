package games.structures.container.turn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @param <A> The type of actions which the players can take
 * @param <E> The type of game engine provided to the players
 * @param <P> The type of players in the game
 * @param <S> The type of game states provided to the players
 *
 * @author Alex
 */
class SimpleContainer<A, E extends GameEngine<A, E, P, S>, P extends Player<A, E, P, S>, S>
    implements Container<A, E, P, S>
{
    public SimpleContainer(S startState, E gameEngine, List<P> players)
    {
        setStartState(startState);
        this.gameEngine = gameEngine;
        this.players = players;
    }

    public S getStartState()
    {
        return startState;
    }

    public void setStartState(S startState)
    {
        this.startState = startState;
    }

    @Override
    public void playGame()
    {
        P currentPlayer = players.get(0);
        S currentState = getStartState();

        while(!gameEngine.isGameCompletedAt(currentState))
        {
            A action = currentPlayer.takeTurn(currentState, gameEngine);
            S nextState = gameEngine.applyActionByAt(action, currentPlayer, currentState);

            for(GameStateChangeListener<A, E, P, S> listener : gameStateChangeListeners)
                listener.onGameStateChanged(currentState, nextState, action, currentPlayer);

            currentPlayer = getNextPlayer(currentPlayer);
            currentState = nextState;
        }
    }

    @Override
    public void addGameStateChangeListener(GameStateChangeListener<A, E, P, S> listener)
    {
        gameStateChangeListeners.add(listener);
    }

    private P getNextPlayer(P currentPlayer)
    {
        int currPlayerIndex = players.indexOf(currentPlayer);

        if(currPlayerIndex+1 >= players.size())
            return players.get(0);

        return players.get(currPlayerIndex+1);
    }

    private S startState;
    private E gameEngine;
    private List<P> players;
    private Set<GameStateChangeListener<A, E, P, S>> gameStateChangeListeners = new HashSet<>();
}
