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

public class Game extends GraphicsProgram implements ActionListener{
	private ArrayList <enemyship> enemies = new ArrayList<enemyship>();
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 800;
	public static final int SIZE = 25;
	enemyship enemyShip;
	
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void run() {
		System.out.println("We are going to print a single ship!");
		addEnemies();
		moveEnemies();
				
	}
	
	private void addEnemies() {
		for(int i = SIZE; i < 800/*WINDOW_WIDTH-SIZE/2*/; i += 50) {
			enemyShip = new enemyship(i, 25, this);
			enemies.add(enemyShip);
		}
		for(int i = SIZE+150; i < 650; i+=50) {
			enemyShip = new enemyship(i, 75, this);
			enemies.add(enemyShip);
		}
	}
	
	private void moveEnemies() {
		for(enemyship e:enemies) {
			e.makeEnemy();
		}
	}
	

	public static void main(String[] args) {
		new Game().start();
	}
}
