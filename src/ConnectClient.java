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
			System.out.println("User "+id+" entrou");
			this.InputStream = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ReadMessages() throws IOException {
		String line = "";
		while (!line.equals(Server.EndConection)){
			try {
				line = InputStream.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("User "+id+ ": " +line);
			serverConfirm();
		}
		System.out.println("User "+id+ " saiu");
	}

	public void close(){
		try {
			clientSocket.close();
			InputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void serverConfirm() throws IOException {
		OutputStream outputStream = Server.clientSocket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		dataOutputStream.writeUTF(Server.serverMenssage);
	}
}