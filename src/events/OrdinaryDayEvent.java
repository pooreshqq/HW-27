package events;

import models.Trader;

import java.util.Random;

public class OrdinaryDayEvent implements Event{
    Random random = new Random();
    @Override
    public String getName() {
        return "Обычный день";
    }

    @Override
    public void apply(Trader trader) {
        trader.travel(trader.getSpeed());
    }
}
