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

	//private static final int SPEED = 5;
	
	enemyship enemyShip;
	enemyship bossShip;
	PlayerShip playerShip;
	
	Game(MainApplication program){
		backround = new GImage("assets/sprites/animatedMenu.gif");
		this.program = program;
		timer = new Timer(50, this);
		//run();
	}	
	
	public void init() {
		program.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void run() {
		program.add(backround);
		addEnemies();
		moveEnemies();
		//addBoss();
		//moveBoss();
		makePlayerShip();
		//playerShip.addKeyListeners();
		timer.start();
	}
	
	//Function Adds Two Rows of Enemies to An arraylist
	private void addEnemies() {
		
		for(int i = SIZE; i < 800/*WINDOW_WIDTH-SIZE/2*/; i += 50) {
			enemyShip = new enemyship(shipType.ENEMYSHIP, i, 25, program);
			enemies.add(enemyShip);
		}
		
		for(int i = SIZE+150; i < 650; i+=50) {
			enemyShip = new enemyship(shipType.ENEMYSHIP, i, 75, program);
			enemies.add(enemyShip);
		}
	}
	//Function Looks into the Arraylist and places the enemies onto the screen
	private void moveEnemies() {
		for(enemyship e:enemies) {
			e.makeEnemy();
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
		} else if (key == KeyEvent.VK_SPACE) {
			playerShip.move(5);
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
		// update all enemies once here
		
	}
}
