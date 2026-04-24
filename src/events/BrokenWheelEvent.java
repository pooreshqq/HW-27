package events;

import models.Trader;

import java.util.Random;

public class BrokenWheelEvent implements Event{

    @Override
    public String getName() {
        return "Сломалось колесо";
    }

    @Override
    public void apply(Trader trader) {
        trader.travel(0);
    }
}
