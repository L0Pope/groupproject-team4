import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class HighScore extends GraphicsPane {

    // you will use program to get access to all of the GraphicsProgram calls
	private GImage backround;
    private MainApplication program;
    private GParagraph para;
    private GButton box1;


    public HighScore(MainApplication app) {
        super();
        backround = new GImage("assets/sprites/animatedMenu.gif");
        program = app;
        box1 = new GButton("Escape", 4, 549, 300/3, 200/5);
    }

    @Override
    public void showContents() {
    	program.add(backround);
        program.add(box1);

    }

    @Override
    public void hideContents() {
        program.removeAll();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        GObject obj = program.getElementAt(e.getX(), e.getY());
        if (obj == box1) {
            program.switchToMenu();
        }
    }



    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 27) {
            program.switchToMenu();
        }
    }
}