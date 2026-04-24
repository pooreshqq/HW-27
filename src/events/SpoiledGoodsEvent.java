package events;

import models.Goods;
import models.Trader;

import java.util.List;
import java.util.Random;

public class SpoiledGoodsEvent implements Event{
    @Override
    public void apply(Trader trader) {
        Random random = new Random();
        List<Goods> goods = trader.getGoodsList();
        if (!goods.isEmpty()) {
            Goods spoiled = goods.get(random.nextInt(goods.size()));
            spoiled.downgradeState();
        }

        trader.travelBy();
    }
}
