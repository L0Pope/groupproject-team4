import java.awt.Color;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

<<<<<<< HEAD
public class PlayerShip {
	public GRect playerShip;
	public int x = 400, y = 400;
	private GraphicsProgram screen;
	private final static int SPEED = 5;
=======
public class PlayerShip extends GraphicsProgram implements KeyListener{
	private GRect playerShip;
	private int x = 400, y = 400;
	private Bullets bullets;
	private final static int SPEED = 10;
	private final static int WINDOW_WIDTH = 600;
	private final static int WINDOW_HEIGHT = 600;
>>>>>>> branch 'main' of https://github.com/Fall2021-COMP55-1/groupproject-team4.git
	
<<<<<<< HEAD
	//Function adds game screen to PlayerShip class
	public PlayerShip(GraphicsProgram screen) {
		this.screen = screen;
	}
=======
	
	
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
>>>>>>> branch 'main' of https://github.com/Fall2021-COMP55-1/groupproject-team4.git
		
<<<<<<< HEAD
	//Function creates playerShip and adds it to game screen
	public void makePlayerShip() {
		playerShip = new GRect(x, y, 50,50);
		playerShip.setColor(new Color(102, 0, 153));
		playerShip.setFilled(true);
		screen.add(playerShip);
	}
	
	//Function controls playerShip image movement
	public void move(int key) {
		if (key == 1) {
=======
		if (key == e.VK_W) {
			y -= SPEED;
>>>>>>> branch 'main' of https://github.com/Fall2021-COMP55-1/groupproject-team4.git
			playerShip.move(0, -SPEED);
<<<<<<< HEAD
		} else if (key == 2) {
=======
		} else if(key == e.VK_A) {
			x -= SPEED;
>>>>>>> branch 'main' of https://github.com/Fall2021-COMP55-1/groupproject-team4.git
			playerShip.move(-SPEED, 0);
<<<<<<< HEAD
		} else if (key == 3) {
=======
		} else if(key == e.VK_S) {
			y += SPEED;
>>>>>>> branch 'main' of https://github.com/Fall2021-COMP55-1/groupproject-team4.git
			playerShip.move(0, SPEED);
<<<<<<< HEAD
		} else {
=======
		} else if (key == e.VK_D) {
			x += SPEED;
>>>>>>> branch 'main' of https://github.com/Fall2021-COMP55-1/groupproject-team4.git
			playerShip.move(SPEED, 0);
		} else if (key == e.VK_SPACE) {
			fireBullet();
		}
<<<<<<< HEAD
=======
		
		
}
		
	public void run() {
		init();
		playerShip = new GRect(x, y, 50,50);
		add(playerShip);
		
>>>>>>> branch 'main' of https://github.com/Fall2021-COMP55-1/groupproject-team4.git
	}
	
}