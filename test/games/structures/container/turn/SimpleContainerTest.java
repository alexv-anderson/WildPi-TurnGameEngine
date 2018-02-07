/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package games.structures.container.turn;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class SimpleContainerTest
{
    @Test
    public void singlePlayerGame()
    {
        SimplePlayer player = new SimplePlayer();
        Container<SimpleAction, SimpleGameEngine, SimplePlayer, SimpleState> container = new SimpleContainer<>(
                SimpleState.EMPTY,
                new SimpleGameEngine(),
                Collections.singletonList(player)
        );

        CountingListener listener = new CountingListener();
        container.addGameStateChangeListener(listener);

        container.playGame();

        assertThat("Listener should have been notified twice", listener.getNumNotifications(), is(2));
        assertThat("Player should be ranked", container.getPlayerRanking(), contains(player));
        assertThat("Player should be ranked 1st", container.getPlayerRanking().indexOf(player), is(0));
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
