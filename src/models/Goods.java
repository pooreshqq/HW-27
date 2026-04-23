package models;

import enums.GoodsType;
import state.NormalState;
import state.State;

public class Goods {
    private int weight;
    private String state;
    private State stateObj;
    private int price;
    private GoodsType type;
    private double coefficient;

    public Goods(int weight, int price, GoodsType type) {
        this.weight = weight;
        this.price = price;
        this.type = type;

        //пока что по умолчанию состояние товара будет нормальным
        setDefaultState();
    }

    //геттеры
    public int getWeight() {
        return weight;
    }

    public String getState() {
        return state;
    }

    public State getStateObj() {
        return stateObj;
    }

    public int getPrice() {
        return price;
    }

    public GoodsType getType() {
        return type;
    }

    public double getCoefficient() {
        return coefficient;
    }

    //сеттеры
    public void setStateObj(State stateObj) {
        this.stateObj = stateObj;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    //утилиты
    private void setDefaultState(){
        this.state = "Нормальное";
        this.stateObj = new NormalState();
        this.coefficient = 1.2;
    }
}
