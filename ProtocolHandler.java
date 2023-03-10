import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface ProtocolHandler {

    void handleRequest(InputStream inputStream, OutputStream outputStream, String clientId) throws IOException;
	void writeResponse(Response response, OutputStream outputStream) throws IOException;
}
