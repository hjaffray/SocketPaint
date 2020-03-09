package jaffrayhenry.du.edu;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaintingPanel<E> extends JPanel {

	ArrayList<E> prims = new ArrayList<E>();
	public PaintingPanel() {
		
		
	}
	
	public void addPrimitive(PaintingPrimitive obj) {
        this.prims.add(obj);
}

public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(PaintingPrimitive obj : prims) {  // I named my ArrayList primitives -- could also use a standard for loop if you wish
                    obj.draw(g);
        }
}
}
