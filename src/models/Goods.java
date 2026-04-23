package models;

import enums.GoodsType;
import exceptions.StateSelectException;
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

    //функции для смены состояния товара
    public void onNormal(){
        if(this.stateObj == null) setDefaultState();
        try{
            this.stateObj.onNormal(this);
        } catch (StateSelectException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Неизвестная ошибка");
        }
    }

    public void onSlightlySpoiled(){
        if(this.stateObj == null) setDefaultState();
        try{
            this.stateObj.OnSlightlySpoiled(this);
        } catch (StateSelectException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Неизвестная ошибка");
        }
    }

    public void onHalfSpoiled(){
        if(this.stateObj == null) setDefaultState();
        try{
            this.stateObj.OnHalfSpoiled(this);
        } catch (StateSelectException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Неизвестная ошибка");
        }
    }

    public void onAlmostGone(){
        if(this.stateObj == null) setDefaultState();
        try{
            this.stateObj.OnAlmostGone(this);
        } catch (StateSelectException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Неизвестная ошибка");
        }
    }

    public void onTotallyRuined(){
        if(this.stateObj == null) setDefaultState();
        try{
            this.stateObj.OnTotallyRuined(this);
        } catch (StateSelectException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Неизвестная ошибка");
        }
    }

    public void downgradeState() {
        if ("Нормальное".equals(state)) {
            onSlightlySpoiled();
        } else if ("Слегка испорчен".equals(state)) {
            onHalfSpoiled();
        } else if ("Половина испортилась".equals(state)) {
            onAlmostGone();
        } else if ("Испорчен в хлам".equals(state)) {
            onTotallyRuined();
        }
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
