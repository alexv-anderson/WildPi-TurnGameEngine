package games.structures.container.turn;

import java.util.List;

/**
 *
 * @param <A> The type of actions which the players can take
 * @param <E> The type of game engine provided to the players
 * @param <P> The type of players in the game
 * @param <S> The type of game states provided to the players
 *
 * @author Alex
 */
public interface GameEngine<A, E extends GameEngine<A, E, P, S>, P extends Player<A, E, P, S>, S>
{
    public List<A> getPossibleActionsForAt(P actingPlayer, S currentState);
    public S applyActionByAt(A action, P actingPlayer, S currentState);
}
