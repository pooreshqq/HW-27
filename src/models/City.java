package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class City {
     private String name;
     private int distance;

     private Random random = new Random();

     private String[] cityNames = {"Berlin", "Moscow", "London", "Paris", "Rome", "Madrid", "Barcelona", "Seoul", "Lima", "Santiago", "Buenos Aires", "Sao Paulo", "Moscow", "Mexico City", "Cape Town", "Lima", "Santiago", "Buenos Aires", "Sao Paulo"};


     public City(){
        this.distance = random.nextInt(0, 200);
        this.name = cityNames[random.nextInt(cityNames.length)];
     }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name;
    }
}
