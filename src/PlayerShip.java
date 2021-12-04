import java.awt.Color;

import javax.imageio.ImageIO;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.graphics.GImage;
import acm.graphics.GOval;


public class PlayerShip {
	public GImage playerShip;
	public healthSystem playerShipHealth;
	//public GRect playerShip2;
	public int x = 400, y = 400;
	private GraphicsProgram screen;
	private Bullets bullets;
	private final static int SPEED = 10;
	private final static int WIDTH = 50;
	private final static int HEIGHT = 50;
	private boolean friendlyBullet = true;


	//Function adds game screen to PlayerShip class
	public PlayerShip(GraphicsProgram screen) {
		playerShipHealth = new healthSystem(shipType.PLAYERSHIP, 3, false);
		this.screen = screen;
		bullets = new Bullets();
	}
	
	
	public void update() {
		updatePlayerBullet();
//		removeBulletsOutOfBounds();
	}
	
	
	public void fireBullet(){
		bullets.addBullet(new Bullet(x,y, -5, 1, friendlyBullet, screen));
	}
	private void updatePlayerBullet() {
		for(Bullet b: bullets.bullets) {
			b.update();
		}
	}
	//Function creates playerShip and adds it to game screen
	public void makePlayerShip() {
		playerShip = new GImage("assets/sprites/UNIT002.gif", x, y);
		//playerShip2 = new GRect(x+10,y+10, WIDTH, HEIGHT);
		//playerShip2.setColor(Color.YELLOW);
		//Used for testing hitbox
		screen.add(playerShip);
		//screen.add(playerShip2);
	}
	public int getPlayerX() {
		return this.x;
	}
	public int getPlayerY() {
		return this.y;
	}
	public int getPlayerWidth() {
		return WIDTH;
	}
	public int getPlayerHeight() {
		return HEIGHT;
	}
	
	//Function controls playerShip image movement
	public void move(int key) {
		if (key == 1) {
			y -= SPEED;
			playerShip.move(0, -SPEED);
			//playerShip2.move(0, -SPEED);

		} else if (key == 2) {
			x -= SPEED;
			playerShip.move(-SPEED, 0);
			//playerShip2.move(-SPEED,0);

		} else if (key == 3) {
			y += SPEED;
			playerShip.move(0, SPEED);
			//playerShip2.move(0, SPEED);

		} else if (key == 4){
			x += SPEED;
			playerShip.move(SPEED, 0);
			//playerShip2.move(SPEED, 0);
			
		} else if (key == 5) {
			fireBullet();
			update();
		}
		
	}

	
}