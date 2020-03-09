package jaffrayhenry.du.edu;

import java.awt.Graphics;
import java.awt.Point;

public class Circle {
	
	Point centerPoint;
	Point radiusPoint;
	
	public Circle(Point a, Point b) {
		
		super();
		centerPoint = a;
		radiusPoint = b;
	}
	
	public void drawGeometry(Graphics g) {
        int radius = (int) Math.abs(centerPoint.distance(radiusPoint));
        g.drawOval(centerPoint.x - radius, centerPoint.y - radius, radius*2, radius*2);           
	}
}
