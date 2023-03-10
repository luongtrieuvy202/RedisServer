public class RequestFactory {
	public static Request createRequest(String inputString,  String clientId) {
		return new Request(inputString,  clientId);
	}
}
