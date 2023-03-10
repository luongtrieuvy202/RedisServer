public class PingCommand implements RedisCommand {
	public String execute() {
		return "+PONG\r\n";
	}
}
