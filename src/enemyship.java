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

public class enemyship extends GraphicsProgram implements ActionListener{
	private ArrayList <GRect> enemies;
	private Timer movement;
	private RandomGenerator rgen;
	
	public static final int SIZE = 25;
	public static final int SPEED = 2;
	public static final int MS = 50;
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 300;
	private int numTimes = -1;
	private Boolean right = true;
	
	public void run() {
		rgen = RandomGenerator.getInstance();
		enemies = new ArrayList <GRect>();
		movement = new Timer(MS, this);
		addAnEnemy();
		movement.start();
		addMouseListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		numTimes ++;
		
		moveAllEnemiesOnce();
	}
	
	private void addAnEnemy() {
		for(int i = SIZE; i < WINDOW_WIDTH-SIZE/2; i += 50) {
			GRect e = makeEnemy(i);
			enemies.add(e);
			add(e);
		}
	}
	public GRect makeEnemy(double x) {
		GRect temp = new GRect(x-SIZE/2, SIZE, SIZE, SIZE);
		temp.setColor(new Color(0,255,0));
		temp.setFilled(true);
		return temp;
	}
	private void moveAllEnemiesOnce() {
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
			for(GRect e:enemies) {
					e.move(2, 0);		
			}
		}
		if(!right) {
			for(GRect e:enemies) {
				e.move(-2, 0);
			}
		}
	}
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public static void main(String args[]) {
		new enemyship().start();
	}
}
