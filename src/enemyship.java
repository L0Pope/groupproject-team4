import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class enemyship extends GraphicsProgram implements ActionListener{
	private Timer movement;
	private RandomGenerator rgen;
	private GraphicsProgram screen;
	private shipType typeShip;
	private healthSystem bossHealth;
	
	public static final int SIZE = 25;
	public static final int SPEED = 2;
	public static final int MS = 50;
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 800;
	private int numTimes = -1;
	public Boolean right = true;
	private int x, y;	
	//private GRect enemy;
	private GImage enemy;
	private Bullets bullets;
	private MainApplication program;
	private boolean friendlyBullet = false;
	
	//Each EnemyShip has its own coordinates, use x and y to locate it 
	public enemyship(shipType typeShip, int x, int y, GraphicsProgram screen) { //location of the ship
		this.typeShip = typeShip;
		this.x=x;
		this.y=y;
		this.screen = screen;
		bullets = new Bullets();
		rgen = RandomGenerator.getInstance();
	
	}	
	
	public void update() {

		bullets.update();
		int rand = rgen.nextInt(1000);
		if(typeShip == shipType.BOSSSHIP) {
			if(rand < 5) {
				fireBullet();
			}
		}else if(typeShip == shipType.ENEMYSHIP) {
			if(rand <3)
				fireBullet();
		}
		}
			
//		removeBulletsOutOfBounds();
	
	
	
	public void fireBullet(){
		bullets.addBullet(new Bullet(x,y, 5, 1, friendlyBullet, screen));
	}
	
	public void run() {
		//rgen = RandomGenerator.getInstance();
		//movement = new Timer(MS, this);
		makeBoss();
		//movement.start();
		//addMouseListeners();
	}
	
	//Makes Single Grect that also has a timer associated with it
	public void makeEnemy() {
		enemy = new GImage("assets/sprites/badguy.gif", x, y);
		//enemy = new GRect(x-SIZE/2, y, SIZE, SIZE);
		//enemy.setColor(new Color(0,255, 0));
		//enemy.setFilled(true);
		screen.add(enemy);
		movement = new Timer(MS, this);
		movement.start();
	}
	
	public void makeBoss() {
		//This is just a temp for the boss
		enemy = new GImage("assets/sprites/badguy.gif");
		//enemy = new GRect(x-SIZE/2, y, SIZE*4, SIZE*4);
		//enemy.setColor(new Color(0,255,0));
		//enemy.setFilled(true);
		//add(enemy);
		bossHealth = new healthSystem(shipType.BOSSSHIP, 3, false);
		screen.add(enemy); // enable this for game.java
		movement = new Timer(MS, this);
		movement.start();
	}
	
	//Calls to the Function that will move the enemies left and right
	public void actionPerformed(ActionEvent e) {
		numTimes ++;
		moveEnemy();
		// remove update from here
		update();
	}
	
	//Utilizes the timer so that it will move left and right everytime the timer reaches 5
	public void moveEnemy() {
		if(typeShip == shipType.ENEMYSHIP) {
			if(numTimes == 5) {
				if(right) {
					right = false;
					numTimes =0;
				}
				else if(!right) {
					right = true;
					numTimes = 0;
				}
			}
			if(right) {
				x += 2;
				enemy.move(2, 0);	//may have to change to check setlocation 	
			}
			if(!right) {
				x +=-2;
				enemy.move(-2, 0);
			}
		}
		else {
			if(numTimes == 130) { // if x is at the end of screen switch
				if(right) {
					right = false;
					numTimes = 0;
				}
				else if(!right) {
					right = true;
					numTimes = 0;
				}
			}
			if(right) {
				x +=5;
				enemy.move(5, 0);
			}
			if(!right) {
				x +=-5;
				enemy.move(-5, 0);
			}
		}
	}
	
	//Call this to Delete the Gobject
	/*private void killEnemy() {
		System.out.println("Dead!");
		remove(enemy);
	}
	*/
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public static void main(String args[]) {
		//new enemyship(shipType.BOSSSHIP, 20,50).start();
	}
}
//add kill enemy function
//change arraylist to single and make arraylist in main
