package events;

import models.Trader;

import java.util.Random;

public class SmoothRoadEvent implements Event{
    @Override
    public String getName() {
        return "Ровная дорога";
    }

    @Override
    public void apply(Trader trader) {
        int distance = Math.min(5, trader.getSpeed() + 2);
        trader.travel(distance);
    }
}
