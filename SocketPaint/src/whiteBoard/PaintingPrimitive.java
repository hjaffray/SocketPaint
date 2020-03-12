package whiteBoard;

import java.awt.Color;
import java.awt.Graphics;


public abstract class PaintingPrimitive{

	Color c; //color variable

	public PaintingPrimitive(Color a) {
		this.c = a;
	}

	public final void draw(Graphics g) {

		g.setColor(this.c);
		drawGeometry(g);
	}

	protected abstract void drawGeometry(Graphics g);
}