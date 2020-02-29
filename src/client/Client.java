package client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    
    private Socket socket = null;
    private DataInputStream input = null;
    private DataInputStream inputFromServer = null;
    private DataOutputStream output = null;
    static Scanner scanner = new Scanner(System.in);
    
    public Client(String address, int port) throws IOException{
        
        socket = new Socket(address, port);
        input = new DataInputStream(System.in);
        inputFromServer = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        output = new DataOutputStream(socket.getOutputStream());
        
        String userInput = "";
        String serverResponse = "";
        
        //this is what I'd imagine the GUI would be most concerned with
        //this while loop reads a string from the server, the sends a string to the server
        //serverResponse = string read from server
        //userInput = string sent to server
        while(!userInput.equals("Disconnect")){
            serverResponse = inputFromServer.readUTF();
            System.out.println(serverResponse);
            userInput = input.readLine();
            output.writeUTF(userInput);
        }
        
        socket.close();
        input.close();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        //System.out.print("Enter the IP addess of the server you wish to connect to: ");
        //String IP = scanner.next();
        Client client = new Client("192.168.0.8", 5000);
    }
}
