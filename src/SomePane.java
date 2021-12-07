import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class SomePane extends GraphicsPane {
    // you will use program to get access to all of the GraphicsProgram calls
    private MainApplication program; 
    private GImage background;
    //private GImage img;
    private GButton returnToMenu;
    private GButton gameOver;


    //All of the comments are references to keep for our game.
    public SomePane(MainApplication app) {
        this.program = app;
        gameOver = new GButton("Game Over", 200, 20, 400, 300);
        returnToMenu = new GButton("Back to menu", 300, 300, 200, 100);
        background = new GImage("assets/sprites/animatedMenu.gif");
        gameOver.setFillColor(new Color(0f,0f,0f,0f ));
        returnToMenu.setFillColor(new Color(0.9f, 0f, 0f, 0.2f));
        returnToMenu.setColor(Color.WHITE);
        gameOver.setColor(Color.red);
    }
    
    @Override
    public void showContents() {
        program.add(background);
        program.add(gameOver);
        program.add(returnToMenu);
    }

    @Override
    public void hideContents() {
        program.remove(gameOver);
        program.remove(returnToMenu);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GObject obj = program.getElementAt(e.getX(), e.getY());
        if (obj == returnToMenu) {
            program.switchToMenu();
        }
    }

   /* @Override
    public void keyPressed(KeyEvent e) {
      //  para.setText("You can\nleave this\nby pressing\n escape");
       // para.setColor(Color.white);
        if(e.getKeyCode() == 27) {
            program.switchToMenu();
            System.out.println("Switching to Main Menu");
            JukeBox.STOP();
        }
    }*/
}