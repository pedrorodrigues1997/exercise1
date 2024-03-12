import api.EventManagerImpl;
import api.IEventManager;
import datatype.Event;
import datatype.Source;

import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        String sourcesFilePath = "src/main/resources/sources.txt";
        String eventsFilePath = "src/main/resources/events.txt";

        List<Source> sources = DataLoader.loadSourcesFromFile(sourcesFilePath);
        List<Event> events = DataLoader.loadEventsFromFile(eventsFilePath);

        IEventManager eventManager = new EventManagerImpl(events);

        List<Event> eventsByTimestamps = eventManager.searchEventsByTimestamps(List.of(1615891200L, 1615892400L));
        List<Event> eventsBySourceId = eventManager.searchEventsBySourceId(1);
        List<Event> eventsByValueRange = eventManager.searchEventsByValueRange(10.0, 20.0);

        System.out.println("Sources: " + sources);
        System.out.println("Events by timestamps: " + eventsByTimestamps);
        System.out.println("Events by source ID: " + eventsBySourceId);
        System.out.println("Events by value range: " + eventsByValueRange);
    }
}
