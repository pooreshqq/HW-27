package events;

import models.Trader;

import java.util.Random;

public interface Event {
    String getName();

    void apply(Trader trader, Random random);
}
