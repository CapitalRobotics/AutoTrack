import java.util.HashMap;
import java.util.Map;

public class MetadataHandler {
    private final Map<String, String> metadata;

    public MetadataHandler() {
        metadata = new HashMap<>();
    }

    public void addMetadata(String key, String value) {
        metadata.put(key, value);
    }

    public String getMetadata(String key) {
        return metadata.getOrDefault(key, "N/A");
    }

    public Map<String, String> getAllMetadata() {
        return new HashMap<>(metadata);
    }
}