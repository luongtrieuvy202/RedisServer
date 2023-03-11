import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;

public class CommandFactory {
	private static final Map<String, Function<List<String>, RedisCommand>> commands = new HashMap<>();

	static {
		commands.put(RedisCommandType.PING, args -> new PingCommand());
		commands.put(RedisCommandType.ECHO, args -> new EchoCommand(args));
		commands.put(RedisCommandType.GET, args -> new GetCommand(args));
		commands.put(RedisCommandType.SET, args -> new SetCommand(args));
	}

	public static RedisCommand createCommand(Request request) {
		List<String> args = new RequestParser().parseArguments(request);
		args.add(request.getClientId());
		String commandType = args.get(0).toUpperCase();
		if (!commands.containsKey(commandType)) {
			return new NotFoundCommand();
		}
		Function<List<String>, RedisCommand> commandFactory = commands.get(commandType);
		return commandFactory.apply(args);
	}
}
