import java.awt.Color;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;


public class PlayerShip {
	public GRect playerShip;
	public int x = 400, y = 400;
	private GraphicsProgram screen;
	private Bullets bullets;
	private final static int SPEED = 5;

	//Function adds game screen to PlayerShip class
	public PlayerShip(GraphicsProgram screen) {
		this.screen = screen;
	}
	
	public PlayerShip(){
		bullets = new Bullets();
	}
	
	
	public void update() {
		bullets.update();	
	}
	
	
	public void fireBullet(){
		bullets.addBullet(new Bullet(x,y, 5, 1));
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
			y -= SPEED;
			playerShip.move(0, -SPEED);
			
		} else if (key == 2) {
			x -= SPEED;
			playerShip.move(-SPEED, 0);
			
		} else if (key == 3) {
			y += SPEED;
			playerShip.move(0, SPEED);
			
		} else if (key == 4){
			x += SPEED;
			playerShip.move(SPEED, 0);
			
		} else if (key == 5) {
			fireBullet();
		}
		
	}
}