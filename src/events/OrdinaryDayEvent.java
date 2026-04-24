package events;

import models.Trader;

import java.util.Random;

public class OrdinaryDayEvent implements Event{

    @Override
    public String getName() {
        return "Обычный день";
    }

    @Override
    public void apply(Trader trader, Random random) {
        trader.travelBy(trader.getSpeed());
    }
}
