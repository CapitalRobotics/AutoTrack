import java.util.ArrayList;
import java.util.List;

public class InputRecorder {
    private final List<String> inputSequence;

    public InputRecorder() {
        inputSequence = new ArrayList<>();
    }

    public void recordInput(String input) {
        inputSequence.add(input);
    }

    public List<String> getInputSequence() {
        return new ArrayList<>(inputSequence);
    }

    public void clearRecording() {
        inputSequence.clear();
    }
}
