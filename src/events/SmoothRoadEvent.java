package events;

import models.Trader;

public class SmoothRoadEvent implements Event{
    @Override
    public void apply(Trader trader) {
        System.out.println("Сегодня вы нашли ровную дорогу. Ваша скорость сегодня повышена на 2 лиги");
        int distance = Math.min(trader.getMaxSpeed(), trader.getSpeed() + 2);
        trader.travelBy();
    }
}
