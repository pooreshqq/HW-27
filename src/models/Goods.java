package models;

import enums.GoodsQuality;
import enums.GoodsType;

public class Goods {
    private int weight;
    private GoodsType type;
    private GoodsQuality quality;
    private int price;

    public Goods(int weight, GoodsType type, GoodsQuality quality, int price) {
        this.weight = weight;
        this.type = type;
        this.quality = quality;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public GoodsType getType() {
        return type;
    }

    public GoodsQuality getQuality() {
        return quality;
    }

    public double getQualityCoefficient() {
        return quality.getCOEFFICIENT();
    }

    public String getQualityDescription() {
        return quality.getDESCRIPTION();
    }

    public int getPrice() {
        return price;
    }
}
