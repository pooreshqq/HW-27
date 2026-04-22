package models;

import java.util.ArrayList;
import java.util.List;

public class Trader {
    private int money;
    private int maxLoadCapacity;
    private int currentLoad;
    private int speed;
    private int distanceToDestination;
    private int traveledDistance;
    private City currentCity;
    private City destinationCity;
    private List<Goods> goodsList;

    public Trader(int money, int maxLoadCapacity, City currentCity) {
        this.money = money;
        this.maxLoadCapacity = maxLoadCapacity;
        this.currentCity = currentCity;
        this.goodsList = new ArrayList<>();
        this.currentLoad = 0;
        this.traveledDistance = 0;
    }

    public boolean canLoad(Goods goods) {
//        if (currentLoad + goods.getВес() > maxLoadCapacity) {
//            return false;
//        }
//
//        if (money < goods.getЦена()) {
//            return false;
//        }

        return true;
    }

    public void addGoods(Goods goods) {
        if (canLoad(goods)){
            goodsList.add(goods);
//            currentLoad += goods.getВес();
//            money -= goods.getЦена();
        }
    }

    public void move() {
        traveledDistance += speed;
    }

    public boolean hasArrived() {
        return traveledDistance >= distanceToDestination;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMoney() {
        return money;
    }

    public List<Goods> getGoodsList(){
        return goodsList;
    }

    public City getCurrentCity(){
        return currentCity;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(City destinationCity, int distance){
        this.destinationCity = destinationCity;
        this.distanceToDestination = distance;
    }

    public int getDistanceToDestination() {
        return distanceToDestination;
    }

    public int getTraveledDistance(){
        return traveledDistance;
    }
}
