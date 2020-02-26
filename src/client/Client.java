package client;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    
    private Socket socket = null;
    private DataInputStream input = null;
    private DataInputStream inputFromServer = null;
    private DataOutputStream output = null;
    GUILogIn log;
    
    public Client(String address, int port) throws IOException{
        
        socket = new Socket(address, port);
        input = new DataInputStream(System.in);
        inputFromServer = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        output = new DataOutputStream(socket.getOutputStream());
        log = new GUILogIn();
        log.setVisible(true);
        
        String userInput = "";
        String serverResponse = "";
        
        while(!userInput.equals("Disconnect")){
            System.out.print("Enter username: ");
            //WaitForButtonPress();
            System.out.print("button pressed");
            userInput = input.readLine();
            output.writeUTF(userInput);
            serverResponse = inputFromServer.readUTF();
            System.out.println(serverResponse);
//          System.out.print("Enter password: ");
//          userInput = input.readLine();
//          output.writeUTF(userInput);
//          serverResponse = inputFromServer.readUTF();
//          System.out.println(serverResponse);
        }
        
        socket.close();
        input.close();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("10.200.253.27", 5000);
    }

    private void WaitForButtonPress() {
        while(log.usernameInput == null){
            
        }
    }
    
}
