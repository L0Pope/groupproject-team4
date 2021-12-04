import java.awt.Color;

import acm.graphics.*;
import acm.graphics.GImage;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Bullet extends Entity{
	private GraphicsProgram screen;
	private static final int WIDTH = 25;
	private static final int HEIGHT = 25;
	private static final int SIZE = 5;
	private boolean friendlyBullet;
	double dy; //velocity
	int damage;
	GImage sprite;
	GOval tempSprite;
	int x; //bullet x coordinate
	int y; //bullet y coordinate

	public Bullet(int x, int y, double dy, int damage, boolean friendlyBullet, GraphicsProgram screen){
		this.x = x;
		this.y = y;
		this.dy = dy;
		this.damage = damage;
		isdead = false;
		this.friendlyBullet = friendlyBullet;
		this.screen = screen;
		
		
		tempSprite = new GOval(x,y,WIDTH,HEIGHT);
		if(friendlyBullet) {
			tempSprite.setColor(Color.white);
		}
		else {
			tempSprite.setColor(Color.red);
		}
		screen.add(tempSprite);

	}
	public int returnBulletX() {
		return this.x;
	}
	public int returnBulletY() {
		return this.y;
	}
	

	
//	public void add(PlayerShip playerShip) {
//		playerShip.add(tempSprite);
//	}
	
	public void removeBullet() {
		screen.remove(tempSprite);
	}
	
		
	public void update() {
		//updates position
		
		y += dy;
		tempSprite.move(0, dy);
		
		//check collision with hitbox
	}
	
	
	public double getX() {
		return x;
	}
	
	
	public double getY() {
		return y;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}

	//public String toString() {
	//	String s = new String();
	//	s += x + " " + y + " " + dy + " " + damage;
					 
	//	return s;
	//}

}
