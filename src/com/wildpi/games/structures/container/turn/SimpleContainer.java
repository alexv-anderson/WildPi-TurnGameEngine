/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A simple bare-bones implementation of {@link Container}
 *
 * @param <GA> The types of actions which may be applied to achieve a change in the state of the game
 * @param <GE> The type of object used to define the rules which govern the game
 * @param <GS> The type of object which represents the state of the overall game
 * @param <P>  The type of object which describes an actor playing the game
 * @param <PS> The type of object which describes the standing or rank of a {@link Player}
 * @param <TA> The types of actions which a {@link Player} may take during their turn (may be different than game actions {@param <GA>})
 * @param <TE> The typeof object used to define the rules which govern how {@link Player}s take their turns
 * @param <TS> The type of object which represents the state of a {@link Player}'s turn
 *
 * @author Alex
 */
class SimpleContainer<
        GA,
        GE extends GameEngine<GA, GE, GS, P, PS, TA, TE, TS>,
        GS,
        P extends Player<GA, GE, GS, P, PS, TA, TE, TS>,
        PS extends PlayerStanding<PS>,
        TA,
        TE extends TurnEngine<GA, GE, GS, P, PS, TA, TE, TS>,
        TS>
    implements Container<GA, GE, GS, P, PS, TA, TE, TS>
{
    public SimpleContainer(GS startState, GE gameEngine, TE turnEngine, List<P> players)
    {
        setStartState(startState);
        this.gameEngine = gameEngine;
        this.turnEngine = turnEngine;
        this.players = players;
    }

    @Override
    public void playGame()
    {
        P currentPlayer = players.get(0);
        GS currentState = getStartState();

        while(!gameEngine.isGameCompletedAt(currentState))
        {
            TS endingTurnState = currentPlayer.takeTurn(
                    turnEngine.getInitialTurnStateForAt(currentPlayer, currentState),
                    turnEngine,
                    currentState,
                    gameEngine);
            GS nextState = getGameStateAfterTurn(endingTurnState, currentPlayer, currentState);

            for(GameStateChangedListener<GA, GE, GS, P, PS, TA, TE, TS> listener : gameStateChangedListeners)
                listener.onGameStateChangedBy(currentState, nextState, currentPlayer);

            currentPlayer = getNextPlayer(currentPlayer);
            currentState = nextState;
        }

        endState = currentState;
    }

    @Override
    public GS getStartState()
    {
        return startState;
    }

    @Override
    public void setStartState(GS startState)
    {
        this.startState = startState;
    }

    @Override
    public void addGameActionListener(GameStateChangedListener<GA, GE, GS, P, PS, TA, TE, TS> listener)
    {
        gameStateChangedListeners.add(listener);
    }

    @Override
    public List<GameRanking<P, PS>> getPlayerStandings()
    {
        GS state = endState != null ? endState : startState;

        //Use Tree sort to get a sorted list of players
        MultiKeyTree<P, PS> tree = new MultiKeyTree<>();
        players.forEach(p -> {
            PS ps = gameEngine.getPlayerStandingForAt(p, state);
            tree.insert(p, ps);
        });

        List<GameRanking<P, PS>> list = new ArrayList<>();
        tree.traverseInOrder((players, standing) -> players.forEach(player -> list.add(new GameRanking<P, PS>() {
            @Override
            public P getPlayer()
            {
                return player;
            }

            @Override
            public PS getPlayerStanding()
            {
                return standing;
            }
        })));

        return list;
    }

    //region Helpers
    private P getNextPlayer(P currentPlayer)
    {
        int currPlayerIndex = players.indexOf(currentPlayer);

        if(currPlayerIndex+1 >= players.size())
            return players.get(0);

        return players.get(currPlayerIndex+1);
    }
    private GS getGameStateAfterTurn(TS endTurnState, P actingPlayer, GS originalState)
    {
        GS currentState = originalState;
        for(GA action : turnEngine.convertToGameActions(endTurnState))
            currentState = gameEngine.getGameStateAfterActionBy(action, actingPlayer, currentState);
        return currentState;
    }
    //endregion

    private GE gameEngine;
    private TE turnEngine;
    private List<P> players;
    private GS startState, endState;
    private Set<GameStateChangedListener<GA, GE, GS, P, PS, TA, TE, TS>> gameStateChangedListeners = new HashSet<>();
}
