import java.awt.Color;

import javax.imageio.ImageIO;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.graphics.GImage;
import acm.graphics.GOval;


public class PlayerShip {
	public GImage playerShip;
	public int x = 400, y = 400;
	private GraphicsProgram screen;
	private Bullets bullets;
	private final static int SPEED = 10;
	private boolean friendlyBullet = true;


	//Function adds game screen to PlayerShip class
	public PlayerShip(GraphicsProgram screen) {
		this.screen = screen;
		bullets = new Bullets();
	}
	
	
	public void update() {
		bullets.update();
//		removeBulletsOutOfBounds();
	}
	
	
	public void fireBullet(){
		bullets.addBullet(new Bullet(x,y, -5, 1, friendlyBullet, screen));
	}
	
	//Function creates playerShip and adds it to game screen
	public void makePlayerShip() {
		playerShip = new GImage("assets/sprites/UNIT002.gif", x, y);
		screen.add(playerShip);
	}
	public int returnPlayerX() {
		return this.x;
	}
	public int returnPlayerY() {
		return this.y;
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
			update();
		}
		
	}

	
}