public class Request implements IRequest {
	private final String request;
	private final String clientId;

	public Request(String request, String clientId) {
		this.request = request;
		this.clientId = clientId;
	}

	public String getRequest() {
		return this.request;
	}

	public String getClientId() {
		return this.clientId;
	}

}
