import java.io.*;
import java.net.*;

public class ConnectClient {
	private Socket clientSocket;
	private DataInputStream InputStream;
	private int id;

	public ConnectClient(Socket clientSocket, int id) {
		this.clientSocket = clientSocket;
		this.id = id;
		try {
			System.out.println("User"+id+ "entrou");
			this.InputStream = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ReadMessages(){
		String line = "";
		while (!line.equals(Server.EndConection)){
			try {
				line = InputStream.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//String nickname = Client.nick.next
			System.out.println("User "+id+ ": " +line);
		}
		System.out.println("User "+id+ "saiu");
	}

	public void close(){
		try {
			clientSocket.close();
			InputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}