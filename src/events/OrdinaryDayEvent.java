package events;

import models.Trader;

public class OrdinaryDayEvent implements Event{
    @Override
    public void apply(Trader trader) {
        System.out.println("Сегодня обычный день. Ничего не произошло");
        trader.travelBy();
    }
}
