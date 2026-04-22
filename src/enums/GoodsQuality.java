package enums;

public enum GoodsQuality {
    NORMAL(1.2, "Нормальное"),
    SLIGHTLY_SPOILED(0.95, "Слегка испорчен"),
    HALF_SPOILED(0.55, "Половина испортилась"),
    ALMOST_GONE(0.25, "Почти весь пропал"),
    TOTALLY_RUINED(0.1, "Испорчен в хлам");

    public final double COEFFICIENT;
    public final String DESCRIPTION;

    private GoodsQuality(double qualityValue, String description) {
        COEFFICIENT = qualityValue;
        DESCRIPTION = description;
    }

    public double getCOEFFICIENT() {
        return COEFFICIENT;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
}
