package studio.rrprojects.storytellergui.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    private String address;
    private int port;

    // constructor to put ip address and port
    public Client(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void OpenConnection() {
        System.out.println("ESTABLISHING CONNECTION: ");

        // establish a connection
        try {
            socket = new Socket(address, port);

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Connected");
        } catch (IOException u) {
            System.out.println("ERROR: " + u);
        }
    }
    
    public void SendMessage() {
        // string to read message from input
        String line = "Hello World!";
        
        try {
            out.writeUTF(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void CloseConnection() {
        System.out.println("CLOSING CONNECTION");
        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }

        System.out.println("CONNECTION CLOSED");
    }
    
}
