package chat;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        final int PUERTO=5000;
        try {
            Socket sock = new Socket("localhost", PUERTO);
            EnviarHilo sendThread = new EnviarHilo(sock);
            Thread thread = new Thread(sendThread);
            thread.start();
            RecibirHiloServidor recieveThread = new RecibirHiloServidor(sock);
            Thread thread2 = new Thread(recieveThread);
            thread2.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


