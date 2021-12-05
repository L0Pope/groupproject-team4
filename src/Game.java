import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Game extends GraphicsPane implements ActionListener{
    
    File Game = new File("assets/bgm/fight!.wav");
    private GImage backround;
    private MainApplication program;
    private SettingPane setting;
    private ArrayList <enemyship> enemies = new ArrayList<enemyship>();
    public static final int WINDOW_HEIGHT = 600;
    public static final int WINDOW_WIDTH = 800;
    public static final int SIZE = 25;
    private Timer timer;
    private int count = 20;

    //private static final int SPEED = 5;
    
    enemyship enemyShip;
    enemyship bossShip;
    PlayerShip playerShip;
    //Hitbox hitbox;
    
    Game(MainApplication program){
        backround = new GImage("assets/sprites/animatedMenu.gif");
        this.program = program;
        //hitbox = new Hitbox();
        timer = new Timer(50, this);
        //hitbox.run();
        //run();
    }    
    
    public void init() {
        program.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }
    
    public void run() {
        program.add(backround);
        addEnemies();
        makeEnemies();
        moveEnemies();
        //addBoss();
        //moveBoss();
        makePlayerShip();
        //playerShip.addKeyListeners();
        timer.start();
        //updateAllBullets();
        
    }
    
    private void updateAllBullets() {
            for(enemyship e : enemies) {
                    for(Bullet b : e.bullets.bullets) {
                        b.update();
                        if( ((playerShip.getPlayerX() < b.returnBulletX()+15) && (b.returnBulletX()-10 < playerShip.getPlayerX() + playerShip.getPlayerWidth()))	
                        && ((playerShip.getPlayerY() < b.returnBulletY()+20) && (b.returnBulletY() < playerShip.getPlayerY()+20 + playerShip.getPlayerHeight()))) {
                            System.out.println("HIT!");
                            b.setXY(20000,20000);
                            playerShip.playerShipHealth.subtractHealth();
                            playerShip.removeHeart();
                            System.out.println(playerShip.playerShipHealth.getHealth());
                            if(playerShip.playerShipHealth.isDestroyed() == true) {
                            	System.out.println("Player is Dead"); //CALL GAME OVER
                            }
                        }
                        //System.out.println(b.returnBulletX());
                        //System.out.println(playerShip.returnPlayerX());
                        //System.out.println("test");
                    }        
            }
            
           // for(enemyship e : enemies) {

        	for(Bullet b : playerShip.bullets.bullets) {
        		for(int i = 0; i < enemies.size(); i++) {
            		if( ((enemies.get(i).getEnemyX() < b.returnBulletX()+15) && (b.returnBulletX()-10 < enemies.get(i).getEnemyX() + playerShip.getPlayerWidth()))	
            		 && ((enemies.get(i).getEnemyY() < b.returnBulletY()+20) && (b.returnBulletY() < enemies.get(i).getEnemyY()+20 + playerShip.getPlayerHeight()))) {
            			 System.out.println("HIT!");
            	         b.setXY(20000,20000);
            	         enemies.get(i).killEnemy(program);
            	         enemies.remove(enemies.get(i));
            	         //program.remove(e.enemy);
            	         //enemies.remove(e);
            	         //enemies.remove(e);
            	         //e.bullets.clearBullet();
            	         }
            		 }
            	}
            	playerShip.update();
            	//System.out.println("test");
            	}

    
    //Function Adds Two Rows of Enemies to An arraylist
    private void addEnemies() {
        
        for(int i = SIZE; i < 750/*WINDOW_WIDTH-SIZE/2*/; i += 50) {
            enemyShip = new enemyship(shipType.ENEMYSHIP, i, 25, program);
            enemies.add(enemyShip);
        }
        
        for(int i = SIZE+100; i < 650; i+=50) {
            enemyShip = new enemyship(shipType.ENEMYSHIP, i, 75, program);
            enemies.add(enemyShip);
        }
    }
    
    private void makeEnemies() {
    	for(enemyship e: enemies) {
    		e.makeEnemy();
    	}
    }
    //Function Looks into the Arraylist and places the enemies onto the screen
    private void moveEnemies() {
        for(enemyship e:enemies) {
          e.numTimes++;
          e.moveEnemy();
        }
    }
    private void addBoss() {
        bossShip = new enemyship(shipType.BOSSSHIP, 20, 50, program);
    }
    
    private void moveBoss() {
        bossShip.makeBoss();
    }
    

    @Override
    public void showContents() {
        run();
    }
    
    @Override
    public void hideContents() {
    	  for(int i = 0; i < enemies.size(); i++) {
              enemies.get(i).finalize();

          }
        program.removeAll();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    
    

    //Calls the PlayerShip class to create and add playerShip onto the screen
    private void makePlayerShip() {
        playerShip = new PlayerShip(program);
        playerShip.makePlayerShip();
        //addKeyListeners();
    }
    
    //KeyListeners used to move playerShip using WASD
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int forward = program.getForward();
        int left = program.getLeft();
        int down = program.getDown();
        int right = program.getRight();
        if (key == forward) {
            playerShip.move(1);
        } else if(key == left) {
            playerShip.move(2);
        } else if(key == down) {
            playerShip.move(3);
        } else if (key == right) {
            playerShip.move(4);
        } 
        if (key == KeyEvent.VK_SPACE) {
        	if(count > 4) {
            playerShip.move(5);
            count = 0;
        	}
        }
        if(key == KeyEvent.VK_ESCAPE) {
            JukeBox.STOP();
            program.switchToMenu();
        }
    }
    
    //Test Test
    public static void main(String[] args) {
        //new Game().start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        playerShip.update();
        updateAllBullets();
        moveEnemies();
        count++;
        for(enemyship enemy : enemies) {
        	enemy.update();
        }
        //hitbox.checkCollision();
        // update all enemies once here
        
    }
}