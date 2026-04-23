package models;

import java.util.ArrayList;
import java.util.List;

public class Trader {
    private int wallet;
    private int maxLoadCapacity;
    private int currentLoad;
    private int speed;
    private int distanceToDestination;
    private int traveledDistance;
    private City currentCity;
    private City destinationCity;
    private List<Goods> goodsList;
    private int maxSpeed;

    public Trader(int wallet, int maxLoadCapacity, City currentCity, int maxSpeed) {
        this.wallet = wallet;
        this.maxLoadCapacity = maxLoadCapacity;
        this.currentCity = currentCity;
        this.maxSpeed = maxSpeed;
        this.goodsList = new ArrayList<>();
        this.currentLoad = 0;
        this.traveledDistance = 0;
    }

    //Проверка можно ли загрузить товар
    public boolean canLoad(Goods goods) {
        if (this.currentLoad + goods.getWeight() > this.maxLoadCapacity) {
            return false;
        }
        if (this.wallet < goods.getPrice()) {
            return false;
        }

        return true;
    }


    //Добавление товара
    public void addGoods(Goods goods) {
        if (canLoad(goods)){ //Если можно загрузить
            this.goodsList.add(goods); //Товар добавляется в список товаров goodList
            this.currentLoad += goods.getWeight(); //Обновление насколько теперь загружен торговец
            this.wallet -= goods.getPrice(); //Обновление кошелька: вычитывается стоимость товара их кошелька торговца
        }
    }


    //Функция движения, возможно, надо переделать
    public void travel(int distance) {
        traveledDistance += Math.max(0, distance);
    }

    public void spendMoney(int amount) {
        wallet = Math.max(0, wallet - amount);
    }

    public void removeGoods(Goods goods) {
        if (goodsList.remove(goods)) {
            currentLoad -= goods.getWeight();
        }
    }

    public void addMoney(int amount) {
        wallet += amount;
    }

    //Проверка прибытия к пункту назначения
    public boolean hasArrived() {
        return traveledDistance >= distanceToDestination;
    }


    //геттеры
    public int getSpeed() {
        return speed;
    }

    public int getMoney() {
        return wallet;
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

    public int getDistanceToDestination() {
        return distanceToDestination;
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
        this.distanceToDestination = distance;
    }
}
