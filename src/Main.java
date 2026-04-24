import enums.GoodsType;
import models.City;
import models.Goods;
import models.Trader;
import state.NormalState;
import state.State;

public class Main {
    public static void main(String[] args) {
        City Berlin = new City("Berlin");
        Trader trader = new Trader(100, 200, Berlin, 10);
    }


    //Цикл
    //Генератор событий
    //trader.travelBy()
}
