package whiteBoard;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) { //make t his do everything that connect does
        try {
            System.out.println("About to call");
            Socket s = new Socket("localhost", 7000); //connects to server over port 7000
            System.out.println("Connected");
            Envelope env;
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Test x = new Test("tom");
            Painter paint = new Painter();
            PaintingPanel panel = new PaintingPanel();
            Color blue = Color.BLUE;
//            PaintingPrimitives shape = new PaintingPrimitives());
//            
//                
//            int input = (int)ois.readObject();
//            env = new Envelope(input);
//            if(env.getCtg() == 0){ //shape
//            	panel.addPrimitive(shape);
//            	env.setShape();
//            	
//            }else if(env.getCtg() == 1) { //message
//            	env.setMsg("");
//            }else { //stat
//            	env.setStat(1);
//            }
//            
            
            
//            oos.writeObject(x); //writes x to the output stream
//            x = (Test)ois.readObject(); //store the next thing written to the input stream as an int in 'x'
//            System.out.println(x);
            s.close(); //close the socket


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}