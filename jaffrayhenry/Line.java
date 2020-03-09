package jaffrayhenry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line {
	
	Point start;
	Point end;

	public Line(Point a, Point b, Color c) {
		super();
		start = a;
		end = b;
		
	}

	public void drawGeometry(Graphics g) {
		g.drawLine(start.x, start.y, end.x, end.y);           
	}
}
