import acm.graphics.*;
import acm.graphics.GImage;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Bullet extends Entity{
	private GraphicsProgram screen;
	private static final int SIZE = 5;
	double dy; //velocity
	int damage;
	GImage sprite;
	GOval tempSprite;


	public Bullet(double x, double y, double dy, int damage, GraphicsProgram screen){
		this.x = x;
		this.y = y;
		this.dy = dy;
		this.damage = damage;
		isdead = false;
		this.screen = screen;
		
		
		tempSprite = new GOval(x,y,50,50);
		screen.add(tempSprite);

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

	

	//public String toString() {
	//	String s = new String();
	//	s += x + " " + y + " " + dy + " " + damage;
					 
	//	return s;
	//}

}
