package api;

import datatype.Event;

import java.util.List;

public interface IEventManager {


    List<Event> searchEventsByTimestamps(List<Long> timestamps);

    List<Event> searchEventsBySourceId(int sourceId);

    List<Event> searchEventsByValueRange(double minValue, double maxValue);



}
