package events;

import models.Trader;

public class BrokenWheelEvent implements Event{
    @Override
    public void apply(Trader trader)
    {
        System.out.println("У вас сломалось колесо, день в пустую, стоим на месте");
    }
}

