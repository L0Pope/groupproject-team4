import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;

import acm.program.GraphicsProgram;

public class MainApplication extends GraphicsProgram {
	
	File menuBGM = new File ("assets/bgm/Menu.wav");
	File test = new File ("assets/bgm/TestAudio.wav");
	File Game = new File("assets/bgm/fight!.wav");
	
	//public static final int WINDOW_WIDTH = 1920;
	public static final int WINDOW_WIDTH = 800;
	//public static final int WINDOW_HEIGHT = 1080;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";

	private GraphicsPane curScreen;
	private SomePane somePane;
	private MenuPane menu;
	private SettingPane setting;
	private HighScore HighScore;
	private Game gameScreen;
	private boolean game = true;
	
	/* Method: setupInteractions
	 * -------------------------
	 * must be called before switching to another
	 * pane to make sure that interactivity
	 * is setup and ready to go.
	 */
	protected void setupInteractions() {
		requestFocus();
		addKeyListeners();
		addMouseListeners();
	}
	
	/* switchToScreen(newGraphicsPane)
	 * -------------------------------
	 * will simply switch from making one pane that was currently
	 * active, to making another one that is the active class.
	 */
	protected void switchToScreen(GraphicsPane newScreen) {
		if(curScreen != null) {
			curScreen.hideContents();
		}
		newScreen.showContents();
		curScreen = newScreen;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mousePressed(e);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseReleased(e);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseClicked(e);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseDragged(e);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseMoved(e);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyPressed(e);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyReleased(e);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyTyped(e);
		}
	}
	

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("yeaaaa");
		somePane = new SomePane(this);
		menu = new MenuPane(this);
		setting = new SettingPane(this);
		HighScore = new HighScore(this);
		gameScreen = new Game(this);
		setupInteractions();
		switchToMenu();
		//JukeBox.PLAY(menuBGM);
		//switchToHighScore();
		//switchToSetting();
	}

	public void switchToSetting() {
		JukeBox.STOP();
		switchToScreen(setting);
		game = !game;
		JukeBox.PLAY(test);
	}
	
	public void switchToMenu() {
		switchToScreen(menu);
		game = !game;
		JukeBox.PLAY(menuBGM);
		
	}

	public void switchToSome() {
		switchToScreen(somePane);
		game = !game;
	}
	
	public void switchToPlay() {
		JukeBox.STOP();
		switchToScreen(gameScreen);
		game = true;
		JukeBox.PLAY(Game);
	}
	
	public void switchToHighScore() {
		JukeBox.STOP();
		switchToScreen(HighScore);
		game = !game;
		JukeBox.PLAY(test);
	}
	
	/*
	public void ENDGAME() {
		new MainApplication().exit();
	}
	*/
	public static void main(String[] args) {
		new MainApplication().start();
	}
	/*
	public char getForward() {
		return setting.getForward();
	}

	public char getLeft() {
		return setting.getLeft();
	}

	public char getDown() {
		return setting.getDown();
	}
	
	public char getRight() {
		return setting.getRight();
	}
	*/

	public int getForward() {
		return setting.getForwardLoc();
	}
	
	public int getLeft() {
		return setting.getLeftLoc();
	}
	
	public int getDown() {
		return setting.getDownLoc();
	}
	
	public int getRight() {
		return setting.getRightLoc();
	}
	
	public int getShoot() {
		return setting.getShootLoc();
	}

}
