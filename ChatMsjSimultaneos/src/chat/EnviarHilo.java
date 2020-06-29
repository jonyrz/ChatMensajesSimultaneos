package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EnviarHilo implements Runnable{
    Socket socket = null;
    PrintWriter print = null;
    BufferedReader brinput = null;
    final int PUERTO=5000;
    public EnviarHilo(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            if (socket.isConnected()) {
                System.out.println("Iniciando en el puerto: "+PUERTO);
                System.out.println("Conexión establecida con el servidor"+ socket.getInetAddress());
                this.print = new PrintWriter(socket.getOutputStream(), true);
                while (true) {
                    brinput = new BufferedReader(new InputStreamReader(System.in));
                    String msjServidor = null;
                    msjServidor = brinput.readLine();
                    this.print.println(msjServidor);
                    this.print.flush();
                    if (msjServidor.equals("Salir")||msjServidor.equals("salir")
                            ||msjServidor.equals("Adios")||msjServidor.equals("adios")) {
                        break;
                    }
                }
                socket.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
