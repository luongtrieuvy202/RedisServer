

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;

public class EchoMultiServer {
	private ServerSocket serverSocket;
	private final ExecutorService threadPool;
	private final ProtocolHandler protocolHandler;


    public EchoMultiServer(ExecutorService threadPool, ProtocolHandler protocol) {
		this.threadPool = threadPool;
		this.protocolHandler = protocol;
    }

    public void start(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		while (true) {
			threadPool.submit(new Task(serverSocket.accept(), protocolHandler));
		}
	}

	public void stop() throws IOException {
		serverSocket.close();
	}
}
