import java.util.List;
import java.util.Map;

public class PathPlayer {

    private final Map<String, Runnable> hardwareActions;

    /**
     * Constructor to initialize PathPlayer with custom hardware mappings.
     *
     * @param hardwareActions A mapping of action names to hardware-specific methods.
     */
    public PathPlayer(Map<String, Runnable> hardwareActions) {
        this.hardwareActions = hardwareActions;
    }

    /**
     * Plays back a recorded path sequence using the provided hardware mappings.
     *
     * @param path A list of recorded movements/actions.
     * @throws InterruptedException If interrupted during movement execution.
     */
    public void playPath(List<String> path) throws InterruptedException {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty.");
        }

        System.out.println("Starting path replay...");
        for (String action : path) {
            System.out.println("Replaying action: " + action);

            Runnable hardwareAction = hardwareActions.get(action);
            if (hardwareAction != null) {
                hardwareAction.run();
            } else {
                System.err.println("Unknown action: " + action);
            }

            Thread.sleep(500); // Optional delay between actions
        }

        System.out.println("Path replay complete.");
    }

    /**
     * Converts a recorded path to a readable format.
     *
     * @param path The list of actions.
     * @return A formatted string for debugging or logging.
     */
    public static String formatPathForLogging(List<String> path) {
        return String.join(" -> ", path);
    }
}
