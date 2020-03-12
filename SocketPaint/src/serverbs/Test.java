package serverbs;
import java.io.Serializable;

public class Test implements Serializable { //class to test sending object over socket
    
    /**
     *
     */
    private static final long serialVersionUID = 1L; //figure this out
    private String name;


    public Test(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String toString() {
        return name;
    }

}