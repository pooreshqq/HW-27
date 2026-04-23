package events;

import models.Goods;
import models.Trader;

import java.util.List;
import java.util.Random;

public class BanditsEvent implements Event{
    @Override
    public String getName() {
        return "Разбойники большой дороги";
    }

    @Override
    public void apply(Trader trader, Random random) {
        List<Goods> goods = trader.getGoodsList();

        int ransom = random.nextInt(20) + 1;

        if (trader.getMoney() >= ransom) {
            trader.spendMoney(ransom);
        } else {
            Goods bestGoods = null;
            double bestValue = -1;

            for (Goods g : goods) {
                double value = g.getPrice() * g.getCoefficient();

                if (value > bestValue) {
                    bestValue = value;
                    bestGoods = g;
                }
            }

            trader.removeGoods(bestGoods);
        }

        trader.travel(0);
    }
}
