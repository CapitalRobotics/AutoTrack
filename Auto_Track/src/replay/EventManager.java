import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private final List<String> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    public void logEvent(String event) {
        events.add(event);
    }

    public List<String> getEvents() {
        return new ArrayList<>(events);
    }
}
