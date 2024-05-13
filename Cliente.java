import java.io.*;
import java.net.*;
import java.util.Scanner; 

public class Cliente {

    public static void main(String[] args) throws IOException {
        int puerto = 5000;
        String ipServidor = "localhost";

        Socket clienteSocket = new Socket(ipServidor, puerto);

        DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());
        DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese mensaje (o //FIN para terminar): ");
            String mensajeUsuario = scanner.nextLine();

            salida.writeUTF(mensajeUsuario);

            if (mensajeUsuario.equals("//FIN")) {
                break;
            }

            String mensajeServidor = entrada.readUTF();
            System.out.println("Servidor: " + mensajeServidor);
        }

        entrada.close();
        salida.close();
        clienteSocket.close();
        scanner.close();
    }
