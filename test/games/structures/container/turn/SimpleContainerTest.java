package games.structures.container.turn;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleContainerTest
{
    @Test
    public void game()
    {
        Container<SimpleAction, SimpleGameEngine, SimplePlayer, SimpleState> container = new SimpleContainer<>(
                new SimpleGameEngine(),
                Collections.singletonList(new SimplePlayer())
        );

        CountingListener listener = new CountingListener();
        container.addGameStateChangeListener(listener);

        container.startGame(SimpleState.EMPTY);

        assertThat("Listener should have been notified twice", listener.getNumNotifications(), is(2));
    }

    private static class CountingListener implements GameStateChangeListener<SimpleAction, SimpleGameEngine, SimplePlayer, SimpleState>
    {
        public int getNumNotifications()
        {
            return numNotifications;
        }

        @Override
        public void onGameStateChanged(SimpleState previousState, SimpleState currentState, SimpleAction actionTaken, SimplePlayer actingPlayer)
        {
            numNotifications++;
        }

        private int numNotifications = 0;
    }
}
