import datatype.Event;
import datatype.Source;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataLoader {

    public static List<Source> loadSourcesFromFile(String filePath) {
        List<Source> sources = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];

                sources.add(createSource(id, name));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sources;
    }




    public static List<Event> loadEventsFromFile(String filePath) {
        List<Event> events = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                int sourceId = Integer.parseInt(parts[1]);
                long timestamp = Long.parseLong(parts[2]);
                double value = Double.parseDouble(parts[3]);

                events.add(createEvent(id, sourceId, timestamp, value));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return events;
    }

    private static Source createSource(int id, String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        return Source.createSource()
                .setId(id)
                .setName(name);
    }

    private static Event createEvent(int id, int sourceId, long timestamp, double value) {
        return Event.createEvent()
                .setId(id)
                .setSourceId(sourceId)
                .setTimestamp(timestamp)
                .setValue(value);
    }
}
