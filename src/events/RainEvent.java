package events;

import models.Goods;
import models.Trader;

import java.util.List;
import java.util.Random;

public class RainEvent implements Event{
    Random random = new Random();
    @Override
    public String getName() {
        return "Дождь";
    }

    @Override
    public void apply(Trader trader) {
        Random random = new Random();
        int distance = Math.max(1, trader.getSpeed() - 2);


        if ((random.nextInt(101)) <= 30) {
            if (trader.getGoodsList().isEmpty()) {
                trader.getGoodsList().get(random.nextInt(trader.getGoodsList().size())).downgradeState();
            }
        }

        trader.travel(distance);
    }
}
