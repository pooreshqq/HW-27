import events.Event;
import utils.EventGenerator;
import models.City;
import models.Goods;
import models.Trader;
import utils.GeneratorGame;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        List<City> cities = GeneratorGame.generateCities();

        City startCity = GeneratorGame.getRandomCity(cities);
        City destination = GeneratorGame.getRandomCity(cities);

        while (destination == startCity) {
            destination = GeneratorGame.getRandomCity(cities);
        }

        int distance = GeneratorGame.generateDistance();

        Trader trader = new Trader(GeneratorGame.generateMoney(), 75, 5, startCity);

        trader.setDestinationCity(destination, distance);

        while (true) {
            Goods goods = GeneratorGame.generateRandomGoods();

            if (trader.canLoad(goods)) {
                trader.addGoods(goods);
            } else {
                break;
            }
        }

        System.out.println("Старт: " + startCity.getName());
        System.out.println("Город назначения: " + destination.getName());
        System.out.println("Расстояние: " + distance);
        System.out.println("Деньги: " + trader.getMoney());

        System.out.println("Товары:");
        for (Goods g : trader.getGoodsList()) {
            System.out.println(g.getType() + " | цена: " + g.getPrice());
        }

        System.out.println("----- ПУТЬ -----");

        EventGenerator eventGenerator = new EventGenerator(random);

        while (!trader.hasArrived()) {
            Event event = eventGenerator.getRandomEvent();

            System.out.println("Событие: " + event.getName());

            event.apply(trader);

            System.out.println("Пройдено: " + trader.getTraveledDistance() + "/" + trader.getDistanceToDestination());

            System.out.println("Деньги: " + trader.getMoney());
            System.out.println("Товаров: " + trader.getGoodsList().size());

            System.out.println("--------------------");
        }

        System.out.println("=== ПРИБЫЛИ ===");

        int total = 0;

        for (Goods g : trader.getGoodsList()) {
            int sellPrice = (int) (g.getPrice() * g.getCoefficient());
            total += sellPrice;
        }

        System.out.println("Выручка: " + total);
        System.out.println("Итоговые деньги: " + (trader.getMoney() + total));

        if (total > 0) {
            System.out.println("Прибыль есть");
        } else {
            System.out.println("Убыток");
        }
    }
}
