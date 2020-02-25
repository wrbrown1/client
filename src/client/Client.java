package client;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    
    public Client(String address, int port) throws IOException{
        
        socket = new Socket(address, port);
        input = new DataInputStream(System.in);
        output = new DataOutputStream(socket.getOutputStream());
        
        String userInput = "";
        
        while(!userInput.equals("Disconnect")){
            userInput = input.readLine();
            output.writeUTF(userInput);         
        }
        
        socket.close();
        input.close();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("10.200.253.27", 5000);
    }
    
}
