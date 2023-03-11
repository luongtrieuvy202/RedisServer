import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;


public class ProtocolHandlerImpl implements ProtocolHandler {
	private final Logger logger = Logger.getLogger(ProtocolHandlerImpl.class.getName());
	
	public static final String COMMAND_SEPARATOR = "\r\n";
	public static final String END_COMMAND = ".";


	public ProtocolHandlerImpl() {
	}

	public void handleRequest(InputStream inputStream,OutputStream outputStream, String clientId) throws IOException {
		StringBuilder requestBuilder = new StringBuilder();
		int nextByte;
		while ((nextByte = inputStream.read()) != -1) {
			char nextChar = (char) nextByte;
			requestBuilder.append(nextChar);
			if(requestBuilder.toString().endsWith(END_COMMAND)){
				Request request = RequestFactory.createRequest(requestBuilder.toString(),clientId);
				Response response = handleEachRequest(request);
				writeResponse(response,outputStream);
				requestBuilder = new StringBuilder();
			}
		}
	}

	private Response handleEachRequest(Request request){
		RedisCommand command = CommandFactory.createCommand(request);
		Response response = ResponseFactory.createResponse(command.execute());
		return response;
	}

	public void writeResponse(Response response, OutputStream outputStream) throws IOException {
		outputStream.write(response.getResponse().getBytes());
	}

}
