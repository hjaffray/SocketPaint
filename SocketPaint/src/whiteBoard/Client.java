package whiteBoard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) { //make this do everything that connect does
        try {
            System.out.println("About to call");
            Socket s = new Socket("localhost", 7000); //connects to server over port 7000
            System.out.println("Connected");

            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Test x = new Test("tom");
            oos.writeObject(x); //writes x to the output stream
            x = (Test)ois.readObject(); //store the next thing written to the input stream as an int in 'x'
            System.out.println(x);
            s.close(); //close the socket


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}