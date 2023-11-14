package escape.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas;            //this class is for the actual display of the game
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		// I used maximum and minimum size so that my game will always stay at the same size
		frame.add(canvas);
		frame.pack();
	}

	public Canvas getCanvas(){  //this getter allows you to access the canvas variable from other classes
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}	