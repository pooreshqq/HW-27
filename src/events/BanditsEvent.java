package events;

import models.Goods;
import models.Trader;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BanditsEvent implements Event {
    @Override
    public String getName() {
        return "Разбойники большой дороги";
    }

    @Override
    public void apply(Trader trader) {
        System.out.println("Вы встретили разбойников большой дороги");

        //если у торговца вообще есть деньги
        if (trader.getWallet() > 0) {
            System.out.println("Вы отдали все деньг");
            trader.setWallet(0);
        } else {
            //нам некому передавать
            trader.giveTheBestGoods();
        }

    }
}