import java.util.ArrayList;
import java.util.List;

public class SensorLogger {
    private final List<String> sensorDataLogs;

    public SensorLogger() {
        sensorDataLogs = new ArrayList<>();
    }

    public void logSensorData(String data) {
        sensorDataLogs.add(data);
    }

    public List<String> getSensorLogs() {
        return new ArrayList<>(sensorDataLogs);
    }

    public void clearLogs() {
        sensorDataLogs.clear();
    }
}
