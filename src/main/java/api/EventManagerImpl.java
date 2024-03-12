package api;

import datatype.Event;
import java.util.List;


public class EventManagerImpl implements IEventManager{

    private List<Event> eventsList;

    public EventManagerImpl(List<Event> eventsList) {
        this.eventsList = eventsList;
    }

    @Override
    public List<Event> searchEventsByTimestamps(List<Long> timestamps) {
        return eventsList.stream()
                .filter(e -> timestamps.contains(e.getTimestamp()))
                .toList();
    }

    @Override
    public List<Event> searchEventsBySourceId(int sourceId) {
        return eventsList.stream()
                .filter(e -> e.getSourceId() == sourceId)
                .toList();
    }

    @Override
    public List<Event> searchEventsByValueRange(double minValue, double maxValue) {
        return eventsList.stream()
                .filter(e-> e.getValue() >= minValue && e.getValue() <= maxValue)
                .toList();
    }
}
