package events;

import models.Trader;

import java.util.Random;

public class RiverEvent implements Event{

    @Override
    public String getName() {
        return "Река";
    }

    @Override
    public void apply(Trader trader, Random random) {
        trader.travel(0);
    }
}
