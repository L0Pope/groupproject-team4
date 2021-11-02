import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class SomePane extends GraphicsPane {
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 

	private GImage img;
	private GParagraph para;
	
	//All of the comments are references to keep for our game.
	public SomePane(MainApplication app) {
		this.program = app;
		//img = new GImage("robot head.jpg", 100, 100); 
		para = new GParagraph("Play Game", 150, 300);
		para.setFont("Comic Sans MS-24");
	}

	@Override
	public void showContents() {
		//program.add(img);
		program.add(para);
	}

	@Override
	public void hideContents() {
		//program.remove(img);
		program.remove(para);
	}
	
	/*
	@Override
	public void mousePressed(MouseEvent e) {
		para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == img) {
			program.switchToMenu();
		}
	}
	*/
	
	@Override
	public void keyPressed(KeyEvent e) {
		para.setText("You can\nleave this\nby pressing\n escape");
		if(e.getKeyCode() == 27) {
			program.switchToMenu();
		}
	}
}
