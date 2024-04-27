import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		new Client();
	}

	private Socket socket;
	private DataOutputStream OutputStream;
	private Scanner menssage;

	public Client(){
		try{
			socket = new Socket("localhost", Server.porta);
			OutputStream = new DataOutputStream(socket.getOutputStream());
			menssage = new Scanner(System.in);
			System.out.println("Bem vindo! Diga algo: ");
			writeMenssage();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeMenssage() throws IOException {
		String line = "";
		while (!line.equals(Server.EndConection)){
			line = menssage.nextLine();
			OutputStream.writeUTF(line);
		}
		close();
	}

	private void close() throws IOException {
		socket.close();
		OutputStream.close();
		menssage.close();
	}
}

