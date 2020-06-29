package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecibirHiloCliente implements Runnable {
    Socket clienteSocket = null;
    BufferedReader brBufferedReader = null;

    public RecibirHiloCliente(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }

    public void run() {
        try {
            brBufferedReader = new BufferedReader(new InputStreamReader(this.clienteSocket.getInputStream()));
            String msjServidor;
            while (true) {
                while ((msjServidor = brBufferedReader.readLine()) != null) {
                    if (msjServidor.equals("Salir")||msjServidor.equals("salir")
                            ||msjServidor.equals("Adios")||msjServidor.equals("adios")) {
                        break;
                    }
                    System.out.println("El cliente dice: " + msjServidor);//Imprime el mensaje desde el cliente 
                }
                this.clienteSocket.close();
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
} 
