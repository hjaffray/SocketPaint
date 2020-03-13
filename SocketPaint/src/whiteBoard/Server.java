package whiteBoard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//import jaffrayhenry.du.edu.*;
import java.util.ArrayList;

public class Server {

    public static void main(String[] args) {
        boolean done = false;
        ArrayList<ClientHandler> painters = new ArrayList<ClientHandler>();
        Updater updater = new Updater(painters);
        updater.run();
        try {
            ServerSocket ss = new ServerSocket(7000);
            while (!done) {
                System.out.println("Waiting for a call");
                Socket s = ss.accept();  // blocking //waits until something trys to connect to the server
                System.out.println("Accepted");
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                ClientHandler t = new ClientHandler(s, ois, oos);
                t.start();
                painters.add(t);
            }

            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Updater extends Thread {
    ArrayList<ClientHandler> painters;
    //store up to date version of the whiteboard and send out when someone first connects
    public Updater(ArrayList<ClientHandler> p) {
        painters = p;
    }

    @Override
    public void run() {
        while (true) {
            for (ClientHandler p : painters) {
                //loop through all of them and look for status bits
                if (p.getStatus() != 1) {

                }
            }
        }


    }

}

class ClientHandler extends Thread {
    Socket s;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    boolean end;
    volatile int status;
// Constructor 
    public ClientHandler(Socket s, ObjectInputStream ois, ObjectOutputStream oos)  
    { 
        this.s = s; 
        this.ois = ois; 
        this.oos = oos;
        end = false; 
        status = 0;
    }
    
    public int getStatus() {
        return status;
    }

    @Override
    public void run() {  
        while (!end)  { 
            try { 

                // Ask user what he wants 
                oos.writeUTF("What do you want?[Date | Time]..\n"+ 
                            "Type Exit to terminate connection."); 
                
                // receive the answer from client 
                Envelope received = (Envelope) ois.readObject();
                
                if(received.getCtg() == 2 && received.stat == 1) {  //update for the correct values, those are just a guess
                    System.out.println("Client " + this.s + " sends exit..."); 
                    System.out.println("Closing this connection."); 
                    this.s.close(); 
                    System.out.println("Connection closed"); 
                    end = true;
                    status = 1;
                } 
                
                
                // write on output stream based on the answer from the client 

            } catch (IOException e) { 
                e.printStackTrace(); 
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } 
        
        try
        { 
            // closing resources 
            this.ois.close(); 
            this.oos.close(); 
            
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    } 
} 