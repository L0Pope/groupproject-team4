import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class PlayerShip extends GraphicsProgram implements KeyListener{
	private GRect playerShip;
	private int x = 400, y = 400;
	private Bullets bullets;
	private final static int SPEED = 10;
	private final static int WINDOW_WIDTH = 600;
	private final static int WINDOW_HEIGHT = 600;
	
	
	
	public PlayerShip(){
		bullets = new Bullets();
	}
	
	
	public void update() {
		bullets.update();	
	}
	
	
	public void fireBullet(){
		bullets.addBullet(new Bullet(x,y, 5, 1));
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == e.VK_W) {
			y -= SPEED;
			playerShip.move(0, -SPEED);
		} else if(key == e.VK_A) {
			x -= SPEED;
			playerShip.move(-SPEED, 0);
		} else if(key == e.VK_S) {
			y += SPEED;
			playerShip.move(0, SPEED);
		} else if (key == e.VK_D) {
			x += SPEED;
			playerShip.move(SPEED, 0);
		} else if (key == e.VK_SPACE) {
			fireBullet();
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