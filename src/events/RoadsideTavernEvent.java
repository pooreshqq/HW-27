package events;

import models.Goods;
import models.Trader;

import java.util.Random;

public class RoadsideTavernEvent implements Event{
    @Override
    public void apply(Trader trader) {
        Random random = new Random();
        int foodCost = 5 + random.nextInt(10) + 1;
        trader.subtractMoneyInWallet(foodCost);

        if (trader.getWallet() > 0 && !trader.getGoodsList().isEmpty()) {
            if (random.nextBoolean()) {
                Goods goods = trader.getGoodsList().get(random.nextInt(trader.getGoodsList().size()));
                trader.removeGoods(goods);
                trader.addMoney((int) Math.round(goods.getPrice() * goods.getCoefficient()));
            }
        }

        trader.travelBy();
    }
}
