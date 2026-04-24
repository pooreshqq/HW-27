package events;

import models.Goods;
import models.Trader;

import java.util.Random;

public class RoadsideTavernEvent implements Event{
    Random random = new Random();

    @Override
    public String getName() {
        return "Придорожный трактир";
    }

    @Override
    public void apply(Trader trader) {
        int foodCost = 5 + random.nextInt(10) + 1;
        trader.spendMoney(foodCost);

        if (trader.getMoney() > 0 && !trader.getGoodsList().isEmpty()) {
            if (random.nextBoolean()) {
                Goods goods = trader.getGoodsList().get(random.nextInt(trader.getGoodsList().size()));
                trader.removeGoods(goods);
                trader.addMoney((int) Math.round(goods.getPrice() * goods.getCoefficient()));
            }
        }

        trader.travel(trader.getSpeed());
    }
}
