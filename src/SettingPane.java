import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import acm.graphics.GObject;

public class SettingPane extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program;
	//private AudioPlayer Audio;
	private GButton rect;
	private GButton rect2;
	private GButton rect3;
	private GButton rect4;
	private GParagraph para0;
	private GParagraph para;
	private GParagraph para2;
	private GParagraph para3;
	private GParagraph para4;
	private boolean test;
	private int num;
	private final int BUTTON_SIZE_X = 300;
	private final int BUTTON_SIZE_Y = 200;
	private final int BUTTON_POS_Y = 100;

	//TODO we need WASD editing, audio.
	public SettingPane(MainApplication app) {
		super();
		program = app;
		para0 = new GParagraph("HOW TO PLAY", 300, 50);
		para0.setFont("Comic Sans MS-24");
		rect = new GButton("W", 259, BUTTON_POS_Y, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para = new GParagraph("Up", 404, BUTTON_POS_Y+25);
		para.setFont("Comic Sans MS-24");
		rect2 = new GButton("A", 259, BUTTON_POS_Y+45, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para2 = new GParagraph("Left", 404, BUTTON_POS_Y+70);
		para2.setFont("Comic Sans MS-24");
		rect3 = new GButton("S", 259, BUTTON_POS_Y+90, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para3 = new GParagraph("Down", 404, BUTTON_POS_Y+115);
		para3.setFont("Comic Sans MS-24");
		rect4 = new GButton("D", 259, BUTTON_POS_Y+135, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para4 = new GParagraph("Right", 404, BUTTON_POS_Y+160);
		para4.setFont("Comic Sans MS-24");
		
	}
//if ascii(w) || ascii(i) ---> if x>
	@Override
	public void showContents() {
		program.add(rect);
		program.add(rect2);
		program.add(rect3);
		program.add(rect4);
		program.add(para0);
		program.add(para);
		program.add(para2);
		program.add(para3);
		program.add(para4);
	}

	@Override
	public void hideContents() {
		program.removeAll();
	}
	
	public void mousePressed(MouseEvent e) {
		System.out.println(e.getX());
		System.out.println(e.getY());
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == rect) {
			test = true;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 27) {
			program.switchToMenu();
		}
		/*This is test code
		  if(e.getKeyCode() == 75) {
			System.exit(0);
		}
		*/
		/*if(test) {
			if(e.getKeyCode() >= 48 && e.getKeyCode() <= 57) {
				
			}
		}
		*/
	}
}
/*
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == audiorec) {
			
		}
	}
}
*/
