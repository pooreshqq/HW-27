package events;

import models.Goods;
import models.Trader;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BanditsEvent implements Event {
    @Override
    public void apply(Trader trader) {
        System.out.println("Сегодня вы встретили разбойников большой дороги");

        if (trader.getWallet() > 0) {
            System.out.println("Вы отдали все деньги разбойникам");
            trader.setWallet(0);
        } else {
            Goods bestGoods = trader.giveTheBestGoods();
            System.out.println("---------------------------------");
            System.out.println("Вы отдали лучший товар: ");
            System.out.printf("Тип: %s%n", bestGoods.getType());
            System.out.printf("Цена: %s%n", bestGoods.getPrice());
            System.out.printf("Вес: %s%n", bestGoods.getWeight());
            System.out.printf("Состояние: %s%n", bestGoods.getState());
            System.out.println("---------------------------------");

        }

        trader.travelBy();

    }
}