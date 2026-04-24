package events;

import models.Goods;
import models.Trader;

import java.util.List;
import java.util.Random;

public class SpoiledGoodsEvent implements Event{
    @Override
    public String getName() {
        return "Товар испортился";
    }

    @Override
    public void apply(Trader trader, Random random) {
        List<Goods> goods = trader.getGoodsList();
        if (!goods.isEmpty()) {
            Goods spoiled = goods.get(random.nextInt(goods.size()));
            spoiled.downgradeState();
        }

        trader.travelBy(trader.getSpeed());
    }
}
