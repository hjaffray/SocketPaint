package whiteBoard;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    ArrayList<PaintingPrimitive> prims;

    public PaintingPanel() {

        prims = new ArrayList<PaintingPrimitive>();
    } 

    public void addPrimitive(PaintingPrimitive obj) {

        prims.add(obj);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        for(PaintingPrimitive obj : prims) {

            obj.draw(g);
        }
    }
}
