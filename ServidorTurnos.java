import java.io.*;
import java.net.*;
import java.util.Scanner; 

public class ServidorTurnos {

    public static void main(String[] args) throws IOException {
        int puerto = 5000;
        ServerSocket servidorSocket = new ServerSocket(puerto);
        Socket clienteSocket = servidorSocket.accept();

        DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());
        DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            String mensajeCliente = entrada.readUTF();
            System.out.println("Cliente: " + mensajeCliente);

            if (mensajeCliente.equals("//FIN")) {
                continuar = false;
            } else {
                String mensajeServidor = scanner.nextLine();
                salida.writeUTF(mensajeServidor);
            }
        }

        entrada.close();
        salida.close();
        clienteSocket.close();
        servidorSocket.close();
    }
}
