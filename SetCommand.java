import java.util.Map;
import java.util.List;

public class SetCommand implements RedisCommand {
	private List<String> args;
	private Map<String, String> mp;

	public SetCommand(List<String> args) {
		this.args = args;
	}

	public String execute() {
		mp = MapFactory.get(args.get(args.size() - 1));
		String key = args.get(1);
		String value = args.get(2);
		mp.put(key, value);
		return "+OK\r\n";
	}
}
