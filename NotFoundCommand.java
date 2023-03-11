public class NotFoundCommand implements RedisCommand {
    public String execute(){
        return "Command Unknown\r\n";
    }
    
}
