import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.graphics.GObject;

public class HighScore extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 			
	private GParagraph para;

	public HighScore(MainApplication app) {
		super();
		program = app;
		para = new GParagraph("Press \"Escape\" to leave", 150, 300);
		para.setFont("Comic Sans MS-24");
	}

	@Override
	public void showContents() {
		program.add(para);
		
	}

	@Override
	public void hideContents() {
		program.remove(para);
	}

	/*
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToMenu();
		}
	}
}
*/
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 27) {
			program.switchToMenu();
		}
	}
}