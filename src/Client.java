import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		String hostname = "localhost";
		Scanner entry = new Scanner(System.in);
		int port;
		System.out.println("Digite a porta que deseja se conectar: ");
		port = entry.nextInt();
		try (Socket socket = new Socket(hostname, port)) {
			System.out.println("Conectado ao server");
			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			while (true){
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				Scanner charmsg = new Scanner(System.in);
				System.out.println("Digite uma mensage: ");
				String menssage = charmsg.nextLine();

				dataOutputStream.writeUTF(menssage);
				dataOutputStream.readUTF(respServer),
			}

		} catch (UnknownHostException e) {
			System.out.println("Server não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O error " + e.getMessage());
		}
	}
}