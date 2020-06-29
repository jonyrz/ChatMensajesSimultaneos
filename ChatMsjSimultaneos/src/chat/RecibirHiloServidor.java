
package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecibirHiloServidor implements Runnable {
    Socket sock = null;
    BufferedReader recieve = null;

    public RecibirHiloServidor(Socket sock) {
        this.sock = sock;
    }

    public void run() {
        try {
            recieve = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
            String mjsRecibido = null;
            while ((mjsRecibido = recieve.readLine()) != null) {
                System.out.println("El servidor dice: " + mjsRecibido);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
