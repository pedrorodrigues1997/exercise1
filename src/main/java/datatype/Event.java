package datatype;

import java.util.Objects;

public class Event {

    private int id;
    private int sourceId;
    private long timestamp;
    private double value;

    public static Event createEvent() {
        return new Event();
    }

    public int getId() {
        return id;
    }

    public Event setId(int id) {
        this.id = id;
        return this;
    }

    public int getSourceId() {
        return sourceId;
    }

    public Event setSourceId(int sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Event setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public double getValue() {
        return value;
    }

    public Event setValue(double value) {
        this.value = value;
        return this;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", timestamp=" + timestamp +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id && sourceId == event.sourceId && timestamp == event.timestamp && Double.compare(event.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceId, timestamp, value);
    }
}

