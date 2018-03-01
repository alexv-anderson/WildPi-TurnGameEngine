/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * @author Alex
 */
public class SimpleContainerTest
{
    @Test
    public void singlePlayerGame() throws GameActionCreationException
    {
        SimplePlayer player = new SimplePlayer();
        Container<
                SimpleGameEngine.SimpleAction,
                SimpleGameEngine,
                SimpleGameEngine.SimpleState,
                SimplePlayer,
                SimplePlayer.Standing,
                SimpleTurnEngine.Action,
                SimpleTurnEngine,
                SimpleTurnEngine.State> container = new SimpleContainer<>(
                SimpleGameEngine.SimpleState.EMPTY,
                new SimpleGameEngine(),
                new SimpleTurnEngine(),
                Collections.singletonList(player)
        );

        CountingListener listener = new CountingListener();
        container.addGameActionListener(listener);

        container.playGame();

        assertThat("Listener should have been notified twice", listener.getNumNotifications(), is(2));
    }

    private static class CountingListener implements GameStateChangedListener<
                SimpleGameEngine.SimpleAction,
                SimpleGameEngine,
                SimpleGameEngine.SimpleState,
                SimplePlayer,
                SimplePlayer.Standing,
                SimpleTurnEngine.Action,
                SimpleTurnEngine,
                SimpleTurnEngine.State>
    {
        public int getNumNotifications()
        {
            return numNotifications;
        }

        @Override
        public void onGameStateChangedBy(SimpleGameEngine.SimpleState previousState, SimpleGameEngine.SimpleState currentState, SimplePlayer actingPlayer)
        {
            numNotifications++;
        }

        private int numNotifications = 0;
    }
}
