import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapFactory {
	private static final Map<String, ConcurrentHashMap<String, String>> maps = new ConcurrentHashMap<>();

	public static Map<String, String> get(String clietId) {
		return maps.computeIfAbsent(clietId, k -> new ConcurrentHashMap<>());
	}

}
