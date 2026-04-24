package events;

import models.Goods;
import models.Trader;

import java.util.List;
import java.util.Random;

public class SpoiledGoodsEvent implements Event{
    @Override
    public void apply(Trader trader) {
        Random random = new Random();
        System.out.println("Сегодня один из товаров испортился");
        List<Goods> goods = trader.getGoodsList();
        if (!goods.isEmpty()) {
            trader.getGoodsList().get(random.nextInt(trader.getGoodsList().size())).downgradeState();
        }
        trader.travelBy();
    }
}
