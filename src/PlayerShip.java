//import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class PlayerShip extends GraphicsProgram implements KeyListener{
	private GRect playerShip;
	private Timer timer;
	private final static int SPEED = 10;
	private final static int WINDOW_WIDTH = 600;
	private final static int WINDOW_HEIGHT = 600;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		//try reading the inputs that are from the settings menu and seeing if the keypress = to the ascii value
		//for example have forward == from the range 40-90 ect
		if (e.getKeyCode() == e.VK_W) {
			playerShip.move(100, 0);
		} else if(key == e.VK_A) {
			playerShip.move(0, -SPEED);
		} else if(key == e.VK_S) {
			playerShip.move(-SPEED,0);
		} else if (key == e.VK_D) {
			playerShip.move(0, SPEED);
		}
}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {
			playerShip.move(SPEED, 0);
		} else if(key == KeyEvent.VK_A) {
			playerShip.move(0, -SPEED);
		} else if(key == KeyEvent.VK_S) {
			playerShip.move(-SPEED,0);
		} else if (key == KeyEvent.VK_D) {
			playerShip.move(0, SPEED);
		}
	}
	
	public void run() {
		init();
		GRect playerShip = new GRect(300, 50, 50,50);
		add(playerShip);
		playerShip.addActionListener(null);
	}
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public static void main(String[] args) {
		new PlayerShip().start();
	}
}
