package whiteBoard;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class Circle extends PaintingPrimitive{
	
	Point centerPoint;
	Point radiusPoint;
	
	public Circle(Point a, Point b, Color c) {
		
		super(c);
		centerPoint = a;
		radiusPoint = b;
	}
	
	public void drawGeometry(Graphics g) {
        int radius = (int) Math.abs(centerPoint.distance(radiusPoint));
        g.drawOval(centerPoint.x - radius, centerPoint.y - radius, radius*2, radius*2);           
	}
}
