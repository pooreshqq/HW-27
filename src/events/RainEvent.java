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
        int distance = Math.max(1, trader.getSpeed() - 2);
        trader.travel(distance);

        if ((random.nextInt(100) + 1) < 30) {
            List<Goods> goods = trader.getGoodsList();
            if (!goods.isEmpty()) {
                Goods spoiled = goods.get(random.nextInt(goods.size()));
                spoiled.downgradeState();
            }
        }
    }
}
