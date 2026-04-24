package events;

import models.Trader;

import java.util.Random;

public interface Event {
    //Для получения имени события
    String getName();

    //Для применения изменений(?) от события
    void apply(Trader trader);
}
