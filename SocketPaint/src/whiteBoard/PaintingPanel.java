package whiteBoard;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    ArrayList<PaintingPrimitive> prims;

    public PaintingPanel() {
        JPanel main = new JPanel();
        main.setBackground(Color.white);
        prims = new ArrayList<PaintingPrimitive>();
    } 

    public void addPrimitive(PaintingPrimitive obj) {

        this.prims.add(obj);
        System.out.println("added prim to list");
        for(int i = 0; i < prims.size(); i++) {
        	
        	System.out.println(prims.get(i));
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
       
        System.out.println("supered pc");
        
//        for(int i = 0; i < prims.size(); i++) {
//        	PaintingPrimitives[] main = new PaintingPrimitives[prims.size()];
//        	main[i].draw(g);
//        	System.out.println("object drawn");
//        }
        for(PaintingPrimitive obj : prims) {
            obj.draw(g);
           // g.drawLine(new Lines(this.getX(), prims., obj.c));
            System.out.println("drew an object");
        }
    }
}

