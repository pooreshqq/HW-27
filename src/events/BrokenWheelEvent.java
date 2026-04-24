package events;

import models.Trader;

public class BrokenWheelEvent implements Event{

    @Override
    public String getName() {
        return "Сломалось колесо";
    }

    @Override
    public void apply(Trader trader)
    {
        trader.travelBy(0);
    }
}

//цикл длаофывдлао:
//генерация события
//trader.travelBy (идем сколько то лиг)


//разбойники
//у него украли один товар
//он идет дальше