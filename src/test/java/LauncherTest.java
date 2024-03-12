import api.EventManagerImpl;
import api.IEventManager;
import datatype.Event;
import datatype.Source;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LauncherTest {
    private static final String sourcesFilePath = "src/main/resources/sources.txt";
    private static final String eventsFilePath = "src/main/resources/events.txt";
    private static final List<Long> timestampList = List.of(1615905600L, 1615909200L);
    List<Source> sources;
    List<Event> events;

    IEventManager eventManager;

    @Before
    public void setup(){
        sources = DataLoader.loadSourcesFromFile(sourcesFilePath);
        events = DataLoader.loadEventsFromFile(eventsFilePath);
        eventManager = new EventManagerImpl(events);

    }

    @Test
    public void testReadFiles(){
        assertEquals(5, sources.size());
        assertEquals(30, events.size());
    }

    @Test
    public void testGetEventsBySourceId(){
        assertEquals(6 ,eventManager.searchEventsBySourceId(sources.get(0).getId()).size());
    }
    @Test
    public void testGetEventsByTimestamps(){
        assertEquals(3 ,eventManager.searchEventsByTimestamps(timestampList).size());
    }
    @Test
    public void testGetEventsByRange(){
        assertEquals(0 ,eventManager.searchEventsByValueRange(30, 55).size());
        assertEquals(25 ,eventManager.searchEventsByValueRange(10, 35).size());
    }

}