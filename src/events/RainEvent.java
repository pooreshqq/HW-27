package events;

import models.Goods;
import models.Trader;

import java.util.List;
import java.util.Random;

public class RainEvent implements Event{
    @Override
    public void apply(Trader trader) {
        Random random = new Random();

        System.out.println("Сегодня пошел дождь. Вы пройдете сегодня на 2 лиги меньше");
        trader.setSpeed(trader.getSpeed() - 2);
        trader.travelBy();
        trader.setSpeed(trader.getSpeed() + 2);

        if ((random.nextInt(101)) <= 30) {
            if (trader.getGoodsList().isEmpty()) {
                trader.getGoodsList().get(random.nextInt(trader.getGoodsList().size())).downgradeState();
            }
        }


    }
}
