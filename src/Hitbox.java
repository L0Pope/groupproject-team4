import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Hitbox extends GraphicsProgram{
	//Playership playerShip;
	private Bullets bulletUse;
	private Timer movement;
	//private int count;
	
	public Hitbox() {
		bulletUse = new Bullets();
	}
	
	public void run() {
		movement = new Timer(50, this);
		movement.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void checkCollision() {
		for(Bullet bullet: bulletUse.bullets) {
			System.out.println("test 1");
			if(getElementAt((bullet.getX()+bullet.getWidth()+1), (bullet.getY() + bullet.getHeight()/2)) instanceof GRect) {
					System.out.println("test 2");
					//remove(getElementAt((bullet.getX()+bullet.getWidth()+1), (bullet.getY() + bullet.getHeight()/2)));
					//enemies.remove(getElementAt((bullet.getX()+bullet.getWidth()+1), (bullet.getY() + bullet.getHeight()/2)));
		}
				//ball.move(SPEED, 0);
			}	
	}
	
	//public void collision() {
		
		
	//}
	
	//}
	
}
