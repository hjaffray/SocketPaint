package whiteBoard;

import java.io.Serializable;

public class Envelope implements Serializable { //Basically the container for sending data to the white boards from the server and vice versa;

    private static final long serialVersionUID = 1L;

    private int ctg; //0 for a shape, 1 for a message, 2 for a painter status update(clear, disconnect, etc);
    public String msg;
    public int stat;
    //public PaintingPrimitive shape; 

    public Envelope(int cat) {
        ctg = cat;

    }

    public void setShape() {
        ctg = 0;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        ctg = 1;
    }

    public void setStat(int stat) {
        this.stat = stat;
        ctg = 2;
    }

    public int getCtg() {
        return ctg;
    }






}