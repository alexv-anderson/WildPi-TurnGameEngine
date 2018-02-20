/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

/**
 * @author Alex
 */
class SimplePlayer implements Player<
        SimpleGameEngine.SimpleAction,
        SimpleGameEngine,
        SimpleGameEngine.SimpleState,
        SimplePlayer,
        SimplePlayer.Standing,
        SimpleTurnEngine.Action,
        SimpleTurnEngine,
        SimpleTurnEngine.State>
{
    @Override
    public SimpleTurnEngine.State takeTurn(SimpleTurnEngine.State turnState, SimpleTurnEngine turnEngine, SimpleGameEngine.SimpleState gameState, SimpleGameEngine gameEngine)
    {
        return SimpleTurnEngine.State.A;
    }

    public static class Standing implements PlayerStanding<SimplePlayer.Standing>
    {

        public Standing(int points)
        {
            this.points = points;
        }

        public int getPoints()
        {
            return points;
        }

        @Override
        public int compareTo(Standing o)
        {
            return Integer.compare(getPoints(), o.getPoints());
        }

        private int points;
    }
}
