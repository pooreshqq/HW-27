package events;

import models.Trader;

public class RiverEvent implements Event{
    @Override
    public void apply(Trader trader) {
        System.out.println("Сегодня вы встретили реку. Вы потратили целый день, пока искал брод");
    }
}
