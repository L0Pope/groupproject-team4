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
	private GImage sprite;
	private GImage badguyBullets;
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
		
		sprite = new GImage("assets/sprites/torpedo.gif",x,y);
		badguyBullets = new GImage("assets/sprites/bossBullets.gif",x,y);
		
		tempSprite = new GOval(x,y,WIDTH,HEIGHT);
		
		
		if(friendlyBullet) {
			tempSprite.setColor(Color.white);
		}
		else {
			tempSprite.setColor(Color.red);
			sprite = badguyBullets;
		}
		screen.add(sprite);

	}
	public int returnBulletX() {
		return this.x;
	}
	public int returnBulletY() {
		return this.y;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
		screen.remove(sprite);
	}
	
//	public void add(PlayerShip playerShip) {
//		playerShip.add(tempSprite);
//	}
	
	public void removeBullet() {
		screen.remove(sprite);
		//sprite.setLocation(0, 0);
	}
	
		
	public void update() {
		//updates position
		
		y += dy;
		sprite.move(0, dy);
		
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
