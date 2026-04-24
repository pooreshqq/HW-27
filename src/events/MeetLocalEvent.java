package events;

import models.Trader;

import java.util.Random;

public class MeetLocalEvent implements Event{

    @Override
    public String getName() {
        return "Встретил местного";
    }

    @Override
    public void apply(Trader trader, Random random) {
        int bonus = 3 + random.nextInt(3) + 1;
        trader.travelBy(trader.getSpeed() + bonus);
    }
}
