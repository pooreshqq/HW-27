package events;

import models.Trader;

import java.util.Random;

public class MeetLocalEvent implements Event{
    @Override
    public void apply(Trader trader) {
        Random random = new Random();


        int bonus = random.nextInt(3, 7);

        System.out.printf("Сегодня вы встретили местного,сегодня удалось срезать часть пути на %s лиги %n", bonus);
        trader.travelBy();
        trader.setDistanceToCity(trader.getDistanceToCity() + bonus);
    }
}
