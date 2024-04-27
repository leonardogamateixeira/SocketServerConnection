import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		new Server();
	}

	private ServerSocket server;
	private Socket clientSocket;
	public static int porta = 2004;
	public static String EndConection = "/end";
	private int id = 0;

	public Server() {
		try{
			server = new ServerSocket(porta);
			System.out.println("Esperando conexão...");
			while(true) iniConnetions();
		} catch (IOException e) {
		//	System.out.println("I/O error " + e);
			System.out.println("Conexão fechada");
		}
	}

	private void iniConnetions() throws IOException {
		clientSocket = server.accept();

		if (clientSocket.isConnected())
		new Thread(()->{
			id++;
			ConnectClient client = new ConnectClient(clientSocket, id);
			client.ReadMessages();
			client.close();
		}).start();

	}
}