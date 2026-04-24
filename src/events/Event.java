package events;

import models.Trader;

public interface Event {
    String getName();
    void apply(Trader trader);
}
