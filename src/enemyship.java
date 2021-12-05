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
    public shipType typeShip;
    public healthSystem bossHealth;
    
    public static final int SIZE = 25;
    public static final int SPEED = 2;
    public static final int MS = 50;
    public static final int WINDOW_HEIGHT = 600;
    public static final int WINDOW_WIDTH = 800;
    public int numTimes = -1;
    public Boolean right = true;
    private int x, y;    
    //private GRect enemy;
    public GImage enemy;
    public Bullets bullets;
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
    
    public int getEnemyX() {
    	return x;
    }
    public int getEnemyY() {
    	return y;
    }
    
    public void update() {

        updateBullet();
        int rand = rgen.nextInt(1500);
        if(typeShip == shipType.BOSSSHIP) {
            if(rand < 100) {
                fireBullet();
            }
        }else if(typeShip == shipType.ENEMYSHIP) {
            if(rand <10)
                fireBullet();
        }
        }
    public void updateBullet() {
        for(Bullet b : bullets.bullets) {
            b.update();
        }
    } 
    
    protected void finalize() {
		//movement.stop();
		bullets.clearBullet();
	}
    
    public void fireBullet(){
        bullets.addBullet(new Bullet(x,y, 5, 1, friendlyBullet, screen));
    }  
    
    public void run() {
        rgen = RandomGenerator.getInstance();
        //movement = new Timer(MS, this);
        makeBoss();
        //movement.start();
        //addMouseListeners();
    }
    
    //Makes Single Grect that also has a timer associated with it
    public void makeEnemy() {
        enemy = new GImage("assets/sprites/badguy.gif", x, y);
        screen.add(enemy);
        //movement = new Timer(MS, this);
        //movement.start();
    }
    
    
    
    public void makeBoss() {
        //This is just a temp for the boss
        enemy = new GImage("assets/sprites/badguy.gif");
        bossHealth = new healthSystem(shipType.BOSSSHIP, 20, false);
        screen.add(enemy); // enable this for game.java
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
                enemy.move(2, 0);    //may have to change to check setlocation     
            }
            if(!right) {
                x +=-2;
                enemy.move(-2, 0);
            }
        }
        else {
            if(numTimes == 150) { // if x is at the end of screen switch
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
    public void killEnemy(GraphicsProgram screen) {
        System.out.println("Dead!");
        screen.remove(enemy);
    }
    
    public void init() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }
    
    public static void main(String args[]) {
        //new enemyship(shipType.BOSSSHIP, 20,50).start();
    }
}