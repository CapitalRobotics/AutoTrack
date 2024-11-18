import java.util.List;

public class AutoTrackController {
    private final InputRecorder inputRecorder;
    private final SensorLogger sensorLogger;
    private final PathPlayer pathPlayer;
    private final MetadataHandler metadataHandler;
    private final EventManager eventManager;

    public AutoTrackController() {
        inputRecorder = new InputRecorder();
        sensorLogger = new SensorLogger();
        pathPlayer = new PathPlayer();
        metadataHandler = new MetadataHandler();
        eventManager = new EventManager();
    }

    /**
     * Records a user-defined input sequence for replay later.
     *
     * @param input The input string representing an action or movement.
     */
    public void recordInput(String input) {
        inputRecorder.recordInput(input);
    }

    /**
     * Logs sensor data during operation.
     *
     * @param data The sensor data to log.
     */
    public void logSensorData(String data) {
        sensorLogger.logSensorData(data);
    }

    /**
     * Adds metadata for the current recording or replay session.
     *
     * @param key The metadata key.
     * @param value The metadata value.
     */
    public void addMetadata(String key, String value) {
        metadataHandler.addMetadata(key, value);
    }

    /**
     * Plays back a previously recorded path.
     */
    public void replayPath() {
        List<String> recordedPath = inputRecorder.getInputSequence();
        if (recordedPath.isEmpty()) {
            System.err.println("No path recorded to replay.");
            return;
        }
        System.out.println("Replaying path...");
        pathPlayer.playPath(recordedPath);
    }

    /**
     * Plays back a path conditionally, based on specified conditions.
     *
     * @param conditions A list of conditions for each step in the path.
     */
    public void replayPathWithConditions(List<String> conditions) {
        List<String> recordedPath = inputRecorder.getInputSequence();
        if (recordedPath.isEmpty()) {
            System.err.println("No path recorded to replay.");
            return;
        }
        if (conditions.size() != recordedPath.size()) {
            System.err.println("Conditions list size must match the path size.");
            return;
        }
        System.out.println("Replaying path with conditions...");
        new ConditionalReplay().playPathWithConditions(recordedPath, conditions);
    }

    /**
     * Clears all recorded data.
     */
    public void clearRecording() {
        inputRecorder.clearRecording();
        sensorLogger.clearLogs();
        eventManager.getEvents().clear();
        System.out.println("All recorded data cleared.");
    }

    /**
     * Retrieves logged sensor data.
     *
     * @return A list of sensor data entries.
     */
    public List<String> getSensorLogs() {
        return sensorLogger.getSensorLogs();
    }

    /**
     * Retrieves all metadata for the current session.
     *
     * @return A map of metadata key-value pairs.
     */
    public String getMetadata(String key) {
        return metadataHandler.getMetadata(key);
    }

    /**
     * Logs custom events during operation.
     *
     * @param event The event to log.
     */
    public void logEvent(String event) {
        eventManager.logEvent(event);
    }

    /**
     * Retrieves all logged events.
     *
     * @return A list of logged events.
     */
    public List<String> getEvents() {
        return eventManager.getEvents();
    }

    /**
     * Example for integrating with FTC hardware.
     *
     * @param driveBase Represents the drivetrain hardware.
     * @param arm       Represents the arm hardware.
     * @param claw      Represents the claw hardware.
     */
    public void integrateHardware(Object driveBase, Object arm, Object claw) {
        // Implement hardware integration logic here
        System.out.println("Hardware integration example:");
        System.out.println("DriveBase: " + driveBase);
        System.out.println("Arm: " + arm);
        System.out.println("Claw: " + claw);
        // Use actual hardware calls in a real implementation.
    }
}