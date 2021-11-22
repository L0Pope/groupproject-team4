import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Game extends GraphicsPane implements ActionListener{
	private MainApplication program;
	private ArrayList <enemyship> enemies = new ArrayList<enemyship>();
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 800;
	public static final int SIZE = 25;
	
	enemyship enemyShip;
	
	Game(MainApplication program){
		this.program = program;
		//run();
	}
	
	
	public void init() {
		program.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void run() {
		addEnemies();
		moveEnemies();
				
	}
	
	//Function Adds Two Rows of Enemies to An arraylist
	private void addEnemies() {
		for(int i = SIZE; i < 800/*WINDOW_WIDTH-SIZE/2*/; i += 50) {
			enemyShip = new enemyship(i, 25, program);
			enemies.add(enemyShip);
		}
		for(int i = SIZE+150; i < 650; i+=50) {
			enemyShip = new enemyship(i, 75, program);
			enemies.add(enemyShip);
		}
	}
	//Function Looks into the Arraylist and places the enemies onto the screen
	private void moveEnemies() {
		for(enemyship e:enemies) {
			e.makeEnemy();
		}
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

	public static void main(String[] args) {
		//new Game().start();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
