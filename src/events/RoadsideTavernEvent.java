package events;

import models.Goods;
import models.Trader;

import java.sql.SQLOutput;
import java.util.Random;

public class RoadsideTavernEvent implements Event{
    @Override
    public void apply(Trader trader) {
        Random random = new Random();
        System.out.println("Сегодня вы встретили придорожный трактир");
        int foodCost = 5 + random.nextInt(10) + 1;
        trader.subtractMoneyInWallet(foodCost);

        if (trader.getWallet() > 0 && !trader.getGoodsList().isEmpty()) {
            if (random.nextBoolean()) {
                Goods goods = trader.getGoodsList().get(random.nextInt(trader.getGoodsList().size()));
                trader.removeGoods(goods);
                trader.addMoney((int) Math.round(goods.getPrice() * goods.getCoefficient()));
                System.out.println();
                System.out.println("Вы продали один из товаров: ");
                System.out.println("---------------------------------");
                System.out.printf("Тип: %s%n", goods.getType());
                System.out.printf("Цена: %s%n", goods.getPrice());
                System.out.printf("Вес: %s%n", goods.getWeight());
                System.out.printf("Состояние: %s%n", goods.getState());
                System.out.println("---------------------------------");
                System.out.printf("Вы заработали: %s%n", (int) Math.round(goods.getPrice() * goods.getCoefficient()));

            }
        }

        trader.travelBy();
    }
}
