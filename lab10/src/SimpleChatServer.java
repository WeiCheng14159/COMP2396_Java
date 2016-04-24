import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleChatServer {
	ArrayList<PrintWriter> clientOutputStreams;
	
	public static void main(String[] args) {
		SimpleChatServer server = new SimpleChatServer();
		server.go();
	}

	public void go() {
		clientOutputStreams = new ArrayList<PrintWriter>();
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			while (true) {
				Socket clientSocket = serverSocket.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				   clientOutputStreams.add(writer);
				   Thread t = new Thread(new ClientHandler(clientSocket));
				   t.start();
				   System.out.println("got a connection");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public class ClientHandler implements Runnable {
		BufferedReader reader;
		Socket sock;
		
		public ClientHandler(Socket clientSocket) {
			try {
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					System.out.println("read " + message);
					broadcasts(message);
				} 
			} catch (Exception ex) { 
				ex.printStackTrace(); 
				}
		}
	}
	
	public void broadcasts(String message) {
		for (PrintWriter writer : clientOutputStreams) {
			try {
				writer.println(message);
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
