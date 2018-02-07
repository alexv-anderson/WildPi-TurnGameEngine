package games.structures.container.turn;

/**
 *
 * @param <A> The type of actions which the players can take
 * @param <E> The type of game engine provided to the players
 * @param <P> The type of players in the game
 * @param <S> The type of game states provided to the players
 *
 * @author Alex
 */
public interface GameStateChangeListener<A, E extends GameEngine<A, E, P, S>, P extends Player<A, E, P, S>, S>
{
    public void onGameStateChanged(S previousState, S currentState, A actionTaken, P actingPlayer);
}
