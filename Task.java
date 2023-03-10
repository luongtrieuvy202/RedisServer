import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class Task implements Runnable {
	private final Socket clientSocket;
	private final ProtocolHandler protocolHandler;

	public Task(Socket clientSocket, ProtocolHandler protocolHandler) {
		this.clientSocket = clientSocket;
		this.protocolHandler = protocolHandler;
	}

	public void run() {
		System.out.println("Connect to client " + clientSocket.toString());
		try (InputStream inputStream = clientSocket.getInputStream();
				OutputStream outputStream = clientSocket.getOutputStream()) {
			protocolHandler.handleRequest(inputStream,outputStream,clientSocket.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
