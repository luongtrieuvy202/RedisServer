

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class RequestParser implements IRequestParser {

	public List<String> parseArguments(IRequest request) {
		List<String> res = Arrays.asList(request.getRequest().replaceAll("[:\\+\\-\\.]", "").split("\r\n"));
		res = res.stream().filter((str) -> !str.startsWith("*") && !str.startsWith("$"))
				.collect(Collectors.toList());
		return res;
	}

}
