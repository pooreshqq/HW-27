package events;

import models.Trader;

import java.util.Random;

public class MeetLocalEvent implements Event{
    Random random = new Random();
    @Override
    public String getName() {
        return "Встретил местного";
    }

    @Override
    public void apply(Trader trader) {
        int bonus = 3 + random.nextInt(3) + 1;
        trader.travel(bonus);
    }
}
