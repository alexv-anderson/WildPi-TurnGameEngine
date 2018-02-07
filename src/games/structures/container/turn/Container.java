package games.structures.container.turn;

/**
 *
 * @param <A> The type of actions which the player can take
 * @param <E> The type of game engine provided to the player
 * @param <P> The type of players in the game
 * @param <S> The type of game states provided to the player
 *
 * @author Alex
 */
public interface Container<A, E extends GameEngine<A, E, P, S>, P extends Player<A, E, P, S>, S>
{
    public void startGame(S startState);
    public void addGameStateChangeListener(GameStateChangeListener<A, E, P, S> listener);
}