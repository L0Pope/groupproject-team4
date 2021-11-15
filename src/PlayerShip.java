import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class PlayerShip extends GraphicsProgram implements KeyListener{
	private GRect playerShip;
	private int x = 400, y = 400;
	private final static int SPEED = 10;
	private final static int WINDOW_WIDTH = 600;
	private final static int WINDOW_HEIGHT = 600;
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == e.VK_W) {
			playerShip.move(0, -SPEED);
		} else if(key == e.VK_A) {
			playerShip.move(-SPEED, 0);
		} else if(key == e.VK_S) {
			playerShip.move(0, SPEED);
		} else if (key == e.VK_D) {
			playerShip.move(SPEED, 0);
		}
}
		
	public void run() {
		init();
		playerShip = new GRect(x, y, 50,50);
		add(playerShip);
	}
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		addKeyListeners();
	}
	
	public static void main(String[] args) {
		new PlayerShip().start();
	}
}