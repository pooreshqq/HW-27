package events;

import models.Trader;

import java.util.Random;

public class RiverEvent implements Event{

    @Override
    public String getName() {
        return "Река";
    }

    @Override
    public void apply(Trader trader) {
        trader.travel(0);
    }
}
