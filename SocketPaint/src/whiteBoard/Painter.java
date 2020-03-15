package whiteBoard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Painter extends JPanel implements ActionListener,MouseListener{
	private  int shapeType; //0 for circle, 1 for line
	private  Color c;
	private Point p1;
	private Point p2;
	private static final long serialVersionUID = 1L;
	PaintingPanel center;

	public Painter(){
		Context context = new Context();
		shapeType = 1;
		p1 = new Point();
		p2 = new Point();
		c = Color.red;
		JFrame main = new JFrame();
		JPanel holder = new JPanel();
		center = new PaintingPanel();
		
		main.setSize(500,500);
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		holder.setLayout(new BorderLayout());

		//center panel
		center.setLayout(new GridLayout(1,1));
		//center.setBackground(Color.CYAN);
		center.addMouseListener(this);
		//center.setActionCommand("draw");
		holder.add(center, BorderLayout.CENTER);
		// Create the paints 
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3, 1)); // 3 by 1
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 3)); //line, circle, and quit
		
		// add red paint button
		JButton redPaint = new JButton();
		redPaint.addActionListener(this);
		redPaint.setActionCommand("red");
		redPaint.setBackground(Color.RED);
		redPaint.setOpaque(true);
		redPaint.setBorderPainted(false);
		leftPanel.add(redPaint);  // Added in next open cell in the grid
		
		// similar for green and blue
		JButton bluePaint = new JButton(); //blue button
		bluePaint.addActionListener(this);
		bluePaint.setActionCommand("blue");
		bluePaint.setBackground(Color.BLUE);
		bluePaint.setOpaque(true);
		bluePaint.setBorderPainted(false);
		leftPanel.add(bluePaint);
		
		JButton greenPaint = new JButton();  //green button
		greenPaint.addActionListener(this);
		greenPaint.setActionCommand("green");
		greenPaint.setBackground(Color.GREEN);
		greenPaint.setOpaque(true);
		greenPaint.setBorderPainted(false);
		leftPanel.add(greenPaint);
		
		JButton line = new JButton("Line");
		line.addActionListener(this);
		line.setActionCommand("line");
		topPanel.add(line); //line button
		
		JButton circle = new JButton("Circle");
		circle.addActionListener(this);
		circle.setActionCommand("circle");
		topPanel.add(circle); //Circle button
//
		JButton quit = new JButton("Quit");
		quit.addActionListener(this);
		quit.setActionCommand("quit");
		topPanel.add(quit); //Quit button
		
		// add the panels to the overall panel, holder
		// note that holder's layout should be set to BorderLayout
		holder.add(leftPanel, BorderLayout.WEST);
		holder.add(topPanel, BorderLayout.NORTH);
		
		
		// after finishing the PaintingPanel class (described later) add a
		// new object of this class as the CENTER panel
		
		// And later you will add the chat panel to the SOUTH
		
		// Lastly, connect the holder to the JFrame
		main.setContentPane(holder);
		main.setVisible(true);
		while(true) {
			
			center.paintComponents(context);
			holder.add(center, BorderLayout.CENTER);
		
		
		
		}
	}

	public static void main(String[] args) {
	
		new Painter();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "red") {
			c = Color.red;
		} else if(e.getActionCommand() == "green") {
			c = Color.green;
		} else if(e.getActionCommand() == "blue") {
			c = Color.blue;
		} else if (e.getActionCommand() == "quit") {
			System.exit(0);
		} else if (e.getActionCommand() == "line") {
			shapeType = 1;
			System.out.println("line");
		} else if (e.getActionCommand() == "circle") {
			shapeType = 0;
			System.out.println("circle");
		}
		System.out.println("action performed");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object source = e.getSource();
		if(source instanceof JPanel) {
			System.out.println("in panel");
			p1 = e.getPoint();
 		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object source = e.getSource();
		if(source instanceof JPanel) {
			System.out.println("in panel");
			p2 = e.getPoint();
			switch (shapeType) {
				case 0:
					center.addPrimitive(new Circle(p1, p2, c));
					break;
				case 1:
					center.addPrimitive(new Line(p1, p2, c));
					break;
			}
		} 		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}