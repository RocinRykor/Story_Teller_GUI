package studio.rrprojects.storytellergui;

import studio.rrprojects.storytellergui.client.Client;
import studio.rrprojects.storytellergui.gui.MainWindow;

public class Controller {
    Client client;

    public Controller() {
        //Load the GUI
        MainWindow mainWindow = new MainWindow(this);
    }

    public static void main(String[] args) {
        Controller Controller = new Controller();
    }

    public void sendAndClose(String s) {
        simpleSend(s);

        //Close Connection
        client.CloseConnection();
    }

    public void ping() {
        simpleSend("ping");

        client.await();
    }

    public void simpleSend(String s) {
        //Connect to Client
        //Start by loading the client and connecting to the server
        client = new Client("127.0.0.1", 5000);
        client.OpenConnection();

        //Send Message
        client.SendMessage(s);
    }
}
