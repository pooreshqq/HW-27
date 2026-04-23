package events;

import java.util.List;
import java.util.Random;

public class EventGenerator {
    private List<Event> events;
    private Random random;

    public EventGenerator (Random random){
        this.random = random;
        this.events = List.of(new BanditsEvent(), new BrokenWheelEvent(), new MeetLocalEvent(), new OrdinaryDayEvent(), new RainEvent(), new RiverEvent(), new RoadsideTavernEvent(), new SmoothRoadEvent(), new SpoiledGoodsEvent());
    }

    public Event getRandomEvent(){
        return events.get(random.nextInt(events.size()));
    }
}
