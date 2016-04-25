import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleChatServer {
	ArrayList<PrintWriter> clientOutputStreams;
	private static int connectionNum = 1;
	
	public static void main(String[] args) {
		SimpleChatServer server = new SimpleChatServer();
		server.go();
		
	}

	public void go() {
		clientOutputStreams = new ArrayList<PrintWriter>();
		try {
			ServerSocket serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(6111));
			serverSocket.setReuseAddress(true);
			
			while (true) {
				Socket clientSocket = serverSocket.accept();//this method block the program execution waiting for connection
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				if( SimpleChatServer.connectionNum <= 4){//valid connection 
					clientOutputStreams.add(writer);
					writer.println("Hi, you are connection #" + SimpleChatServer.connectionNum);
					writer.flush();
					Thread t = new Thread(new ClientHandler(clientSocket));
					t.start();
					System.out.println("got a connection num" + SimpleChatServer.connectionNum);
					SimpleChatServer.connectionNum++;
					
				}else{//too  much connection 
					writer.println("sorry, we already have 4 connections \n connection closed ");
					writer.close();
				}
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
				SimpleChatServer.connectionNum--;
				System.out.println("connection count - 1");
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
