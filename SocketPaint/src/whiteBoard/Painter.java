package whiteBoard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Painter extends JPanel{
	public static void main(String[] args) {
	
		Painter test = new Painter();
		
		System.out.println("here");
		
		
	}

	public Painter(){
		JFrame main = new JFrame();
		JPanel holder = new JPanel();
		
		main.setSize(500,500);
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		holder.setLayout(new BorderLayout());
		
		// Create the paints 
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3, 1)); // 3 by 1
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 2));
		
		// add red paint button
		JButton redPaint = new JButton();
		redPaint.setBackground(Color.RED);
		redPaint.setOpaque(true);
		redPaint.setBorderPainted(false);
		leftPanel.add(redPaint);  // Added in next open cell in the grid
		
		// similar for green and blue
		JButton bluePaint = new JButton(); //blue button
		bluePaint.setBackground(Color.BLUE);
		bluePaint.setOpaque(true);
		bluePaint.setBorderPainted(false);
		leftPanel.add(bluePaint);
		
		JButton greenPaint = new JButton();  //green button
		greenPaint.setBackground(Color.GREEN);
		greenPaint.setOpaque(true);
		greenPaint.setBorderPainted(false);
		leftPanel.add(greenPaint);
		
		JButton line = new JButton("Line");
		topPanel.add(line);
		
		JButton circle = new JButton("Circle");
		topPanel.add(circle);
		
		// add the panels to the overall panel, holder
		// note that holder's layout should be set to BorderLayout
		holder.add(leftPanel, BorderLayout.WEST);
		holder.add(topPanel, BorderLayout.NORTH);
		
		
		// use similar code to add topPanel buttons to the NORTH region
		// omit the center panel for now
		// after finishing the PaintingPanel class (described later) add a
		// new object of this class as the CENTER panel
		
		// And later you will add the chat panel to the SOUTH
		
		// Lastly, connect the holder to the JFrame
		main.setContentPane(holder);
		
		// And make it visible to layout all the components on the screen
		main.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		
	
	}
}
