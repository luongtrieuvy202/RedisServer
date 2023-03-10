
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	private static final int POOL_SIZE = 3;

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		ProtocolHandler protocol = new ProtocolHandlerImpl();
		EchoMultiServer server = new EchoMultiServer(threadPool, protocol);
		try {
			server.start(5555);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
