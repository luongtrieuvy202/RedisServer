import java.util.Map;
import java.util.List;

public class GetCommand implements RedisCommand {
	private List<String> args;

	public GetCommand(List<String> args) {
		this.args = args;
	}

	public String execute() {
		Map<String, String> mp = MapFactory.get(args.get(args.size() - 1));
		String key = args.get(1);
		String value = mp.get(key);

		if (value == null) {
			return "$-1\r\n";
		} else {
			return "$" + value.length() + "\r\n" + value + "\r\n";
		}
	}
}
