import java.util.List;

public class EchoCommand implements RedisCommand {

	List<String> args;

	public EchoCommand(List<String> args) {
		this.args = args;
	}

	public String execute() {
		return args.get(1) + "\r\n";
	}
}
