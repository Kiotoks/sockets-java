import java.io.*;
import java.net.*;

public class ServidorBitacora {

    public static void main(String[] args) throws IOException {
        int puerto = 5000;
        ServerSocket servidorSocket = new ServerSocket(puerto);
        Socket clienteSocket = servidorSocket.accept();

        DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());
        DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());

        boolean continuar = true;

        while (continuar) {
            String mensajeCliente = entrada.readUTF();
            System.out.println("Cliente: " + mensajeCliente);
            salida.writeUTF("Mensaje recibido");
            if (mensajeCliente.equals("//FIN")) {
                continuar = false;
                salida.writeUTF("Conexion cerrada");
            } 
            
        }

        entrada.close();
        salida.close();
        clienteSocket.close();
        servidorSocket.close();
    }
}
