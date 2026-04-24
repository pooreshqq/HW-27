package utils;

import enums.GoodsType;
import models.City;
import models.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorGame {
    private static final Random random = new Random();

    public static List<City> generateCities() {
        List<City> cities = new ArrayList<>();

        cities.add(new City("Бишкек", List.of("MEAT", "FLOUR")));
        cities.add(new City("Ош", List.of("DYE", "FABRIC")));
        cities.add(new City("Нарын", List.of("SEED")));
        cities.add(new City("Талас", List.of("DRIED_FRUIT")));
        cities.add(new City("Каракол", List.of("MEAT", "DYE")));

        return cities;
    }

    public static City getRandomCity(List<City> cities) {
        return cities.get(random.nextInt(cities.size()));
    }

    public static int generateDistance() {
        return 50 + random.nextInt(50) + 1;
    }

    public static Goods generateRandomGoods() {
        GoodsType[] types = GoodsType.values();
        GoodsType type = types[random.nextInt(types.length)];

        int weight = 1 + random.nextInt(5) + 1;
        int price = 10 + random.nextInt(50) + 1;

        return new Goods(weight, price, type);
    }

    public static int generateMoney() {
        return 100 + random.nextInt(100) + 1;
    }
}
