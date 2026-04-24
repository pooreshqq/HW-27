package events;

import models.Trader;

import java.util.Random;

public class SmoothRoadEvent implements Event{
    @Override
    public String getName() {
        return "Ровная дорога";
    }

    @Override
    public void apply(Trader trader, Random random) {
        int distance = Math.min(trader.getMaxSpeed(), trader.getSpeed() + 2);
        trader.travelBy(distance);
    }
}
