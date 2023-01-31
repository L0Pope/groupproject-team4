import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class SomePane extends GraphicsPane {
    private MainApplication program; 
    private GImage background;
    private GButton returnToMenu;
    private GButton gameOver;
    private GButton winOver;
    private GButton winReturnToMenu;
    private boolean names = false;
    private char input;
    private String FullName = "";
    public GButton scores;
    public GButton name;
    public boolean death = false;
    public int score = 0;

    public SomePane(MainApplication app) {
    		this.program = app;
    		gameOver = new GButton("Game Over", 200, 20, 400, 300);
    		returnToMenu = new GButton("Back to menu", 300, 300, 200, 100);
    		background = new GImage("assets/sprites/animatedMenu.gif");
        	gameOver.setFillColor(new Color(0f,0f,0f,0f ));
        	returnToMenu.setFillColor(new Color(0.9f, 0f, 0f, 0.2f));
        	returnToMenu.setColor(Color.WHITE);
        	gameOver.setColor(Color.red);

    		winOver = new GButton("You Win!", 200, 20, 400, 300);
    		winReturnToMenu = new GButton("Back to menu", 300, 300, 200, 100);
    		background = new GImage("assets/sprites/animatedMenu.gif");
        	winOver.setFillColor(new Color(0f,0f,0f,0f ));
        	winReturnToMenu.setFillColor(new Color(0f, 0.9f, 0f, 0.2f));
        	winReturnToMenu.setColor(Color.WHITE);
        	winOver.setColor(Color.green);
        	
        	name = new GButton ("Please Input Name", 200, 200, 100, 100);
        	name.setFillColor(new Color(0f,0f,0f,0f ));
        	name.setColor(Color.WHITE);
        	
        	scores = new GButton("Score: ", 285, 200, 100, 100);
        	scores.setFillColor(new Color(0.9f,0f,0f,0f ));
        	scores.setColor(Color.WHITE);
    }
    
    public String getInitials() {
    	return FullName;
    }
    
    @Override
    public void showContents() {
        program.add(background);
    	if (!death) {
    		program.add(gameOver);
    		program.add(returnToMenu);
    		scores.setText("Your score is: " + score);
    		program.add(scores);
    		program.add(name);
    	} else {
    		program.add(winOver);
    		program.add(winReturnToMenu);
    		scores.setText("Your score is: " + score);
    		program.add(scores);
    		program.add(name);
    	}
    }

    @Override
    public void hideContents() {
    	if (!death) {
    		program.remove(gameOver);
    		program.remove(returnToMenu);
    	} else {
    		program.remove(winOver);
    		program.remove(winReturnToMenu);
    	}
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GObject obj = program.getElementAt(e.getX(), e.getY());
        if (obj == name) {
        	names = true;
        }
        if (obj == returnToMenu || obj == winReturnToMenu) {
        	JukeBox.STOP();
            program.switchToMenu();
        }
    }
    
    public void keyPressed(KeyEvent e) {
		if(names) {
			if(((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122))){
				input = e.getKeyChar();;
				FullName += input;
				name.setText(FullName);
				names = !names;
			}
		} 
    }
}