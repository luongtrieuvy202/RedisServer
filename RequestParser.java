import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Arrays;

public class RequestParser implements IRequestParser {


	public List<String> parseArguments(IRequest request) {
		String input = request.getRequest().replaceFirst("^[\\r\\n]+","");
		input = input.replaceAll("[:\\+\\-\\.]", "");
		String[] parts = input.split("\\\\r\\\\n");
		List<String> res = Arrays.stream(parts)
								 .filter(s -> !s.startsWith("*") && !s.startsWith("$"))
								 .collect(Collectors.toList());
		res.forEach(System.out::println);
		return res;
		
	}

}
