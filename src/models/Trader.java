package models;

import java.util.ArrayList;
import java.util.List;

public class Trader {
    private int wallet;
    private int maxLoadCapacity;
    private int currentLoad;
    private int speed; //текущая скорость, сколько он преодолевает в день
    private int maxSpeed;
    private int distanceToCity; //сколько он должен пройти до города
    private int traveledDistance; //сколько он уже прошел
    private City destinationCity; //Город выбирается в начале и может быть только один
    private List<Goods> goodsList;

    private boolean canTravel = true;
    private boolean isArrived = false;


    public Trader(int wallet, int maxLoadCapacity, City destinationCity, int maxSpeed) {
        this.wallet = wallet;
        this.maxLoadCapacity = maxLoadCapacity;
        this.destinationCity = destinationCity;
        this.maxSpeed = maxSpeed;
        this.goodsList = new ArrayList<>();
        this.currentLoad = 0;
        this.traveledDistance = 0;
    }

    public boolean canLoad(Goods goods) {
        if (this.currentLoad + goods.getWeight() > this.maxLoadCapacity) {
            return false;
        }
        if (this.wallet < goods.getPrice()) {
            return false;
        }

        return true;
    }


    public void addGoods(Goods goods) {
        if (canLoad(goods)){
            this.goodsList.add(goods);
            this.currentLoad += goods.getWeight();
            this.wallet -= goods.getPrice();
        }
    }


    public void travelBy() {
        if(isArrived){
            System.out.println("Вы уже в городе назначения");
            return;
        }
        if(hasArrived()) {
            this.isArrived = true;
            System.out.println("Вы дошли до города назначения");
            return;
        }
        this.traveledDistance += Math.max(0, this.speed);
    }

    public void subtractMoneyInWallet(int amount) {
        this.wallet = Math.max(0, wallet - amount);
    }

    public Goods giveTheBestGoods(){
        Goods bestGoods = null;
        double bestValue = Integer.MIN_VALUE;

        for (Goods goods : this.goodsList) {

            double value = goods.getPrice() * goods.getCoefficient();


            if (value > bestValue) {
                bestValue = value;
                bestGoods = goods;
            }
        }

        removeGoods(bestGoods);
        subtractMoneyInWallet((int) bestValue);
        return bestGoods;
    }

    public void removeGoods(Goods goods) {
        if (goodsList.remove(goods)) {
            currentLoad -= goods.getWeight();
        }
    }

    public void addMoney(int amount) {
        wallet += amount;
    }


    public boolean hasArrived() {
        return traveledDistance >= distanceToCity;
    }


    //геттеры
    public int getSpeed() {
        return speed;
    }

    public int getWallet() {
        return wallet;
    }

    public List<Goods> getGoodsList(){
        return goodsList;
    }

    public boolean isArrived() {
        return isArrived;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public int getDistanceToCity() {
        return distanceToCity;
    }

    public int getTraveledDistance(){
        return traveledDistance;
    }

    public int getMaxSpeed(){
        return maxSpeed;
    }


    //сеттеры
    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void setDestinationCity(City destinationCity, int distance){
        this.destinationCity = destinationCity;
        this.distanceToCity = distance;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void setDistanceToCity(int distanceToCity) {
        this.distanceToCity = distanceToCity;
    }

    public void setTraveledDistance(int traveledDistance) {
        this.traveledDistance = traveledDistance;
    }
}
