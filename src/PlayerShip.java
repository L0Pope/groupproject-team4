import java.awt.Color;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class PlayerShip {
	public GRect playerShip;
	public int x = 400, y = 400;
	private GraphicsProgram screen;
	private final static int SPEED = 5;
	
	//Function adds game screen to PlayerShip class
	public PlayerShip(GraphicsProgram screen) {
		this.screen = screen;
	}
		
	//Function creates playerShip and adds it to game screen
	public void makePlayerShip() {
		playerShip = new GRect(x, y, 50,50);
		playerShip.setColor(new Color(102, 0, 153));
		playerShip.setFilled(true);
		screen.add(playerShip);
	}
	
	//Function controls playerShip image movement
	public void move(int key) {
		if (key == 1) {
			playerShip.move(0, -SPEED);
		} else if (key == 2) {
			playerShip.move(-SPEED, 0);
		} else if (key == 3) {
			playerShip.move(0, SPEED);
		} else {
			playerShip.move(SPEED, 0);
		}
	}
	
}