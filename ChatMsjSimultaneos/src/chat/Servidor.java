package chat;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        final int PUERTO = 5000;
        System.out.println("Iniciando en el puerto: "+PUERTO);
        ServerSocket ss = new ServerSocket(PUERTO);
            Socket clienteSocket = ss.accept();
            System.out.println("Nuevo cliente recibido"+clienteSocket);
            System.out.println("Conexion establecida con el cliente" + clienteSocket.getInetAddress());
            //Crea dos hilos para enviar y recibir desde el cliente
            RecibirHiloCliente recibir = new RecibirHiloCliente(clienteSocket);
            Thread thread = new Thread(recibir);
            thread.start();
            EnviarHilo enviar = new EnviarHilo(clienteSocket);
            Thread thread2 = new Thread(enviar);
            thread2.start();
    }
}


