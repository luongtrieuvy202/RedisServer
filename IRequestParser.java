import java.util.List;

public interface IRequestParser {
	List<String> parseArguments(IRequest request);
}
