import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		Scanner entry = new Scanner(System.in);
		int port;
		System.out.println("Digite uma porta desejada: ");
		port = entry.nextInt();
		try (ServerSocket ss = new ServerSocket(port)) {
			System.out.println("O Server está ouvindo a porta " + port);
			while (true) {
				Socket socket = ss.accept();
				System.out.println("Novo cliente conectado ");
				InputStream inputStream = socket.getInputStream();
				DataInputStream dataInputStream = new DataInputStream(inputStream);
				OutputStream outputStream = socket.getOutputStream();
				DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

				String message = dataInputStream.readUTF();
				System.out.println("User: " + message);

				Scanner Smsg = new Scanner(System.in);
				System.out.println("Digite uma mensage: ");
				String messageServer = Smsg.nextLine();
				dataOutputStream.writeUTF(messageServer);

				dataOutputStream.close();
				dataInputStream.close();
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("Server exception: " + e.getMessage());
		}
	}
}