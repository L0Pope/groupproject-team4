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
	private GButton ERROR;
	private GButton escape;
	private GParagraph para0;
	private GParagraph para;
	private GParagraph para2;
	private GParagraph para3;
	private GParagraph para4;
	private boolean UpRec;
	private boolean box1;
	private boolean LeftRec;
	private boolean box2;
	private boolean DownRec;
	private boolean box3;
	private boolean RightRec;
	private boolean box4;
	private char Forward = 'W';
	private char Left = 'A';
	private char Down = 'S';
	private char Right = 'D';
	private final int BUTTON_SIZE_X = 300;
	private final int BUTTON_SIZE_Y = 200;
	private final int BUTTON_POS_Y = 100;

	//TODO we need WASD editing, audio.
	public SettingPane(MainApplication app) {
		super();
		program = app;
		para0 = new GParagraph("HOW TO PLAY", 300, 50);
		para0.setFont("Comic Sans MS-24");
		rect = new GButton(Forward, 259, BUTTON_POS_Y, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para = new GParagraph("Up", 404, BUTTON_POS_Y+25);
		para.setFont("Comic Sans MS-24");
		rect2 = new GButton(Left, 259, BUTTON_POS_Y+45, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para2 = new GParagraph("Left", 404, BUTTON_POS_Y+70);
		para2.setFont("Comic Sans MS-24");
		rect3 = new GButton(Down, 259, BUTTON_POS_Y+90, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para3 = new GParagraph("Down", 404, BUTTON_POS_Y+115);
		para3.setFont("Comic Sans MS-24");
		rect4 = new GButton(Right, 259, BUTTON_POS_Y+135, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para4 = new GParagraph("Right", 404, BUTTON_POS_Y+160);
		para4.setFont("Comic Sans MS-24");
		escape = new GButton("Escape", 4, 549, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		//This just makes it so its easy to call later
		ERROR = new GButton("This shouldnt have happen", 259, BUTTON_POS_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y, Color.white);
		ERROR.setFillColor(Color.black);
		ERROR.setColor(Color.white);
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
		program.add(escape);
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
			UpRec = true;
			LeftRec = false;
			DownRec = false;
			RightRec = false;
		}
		if(obj == rect2) {
			UpRec = false;
			LeftRec = true;
			DownRec = false;
			RightRec = false;
		}
		if(obj == rect3) {
			UpRec = false;
			LeftRec = false;
			DownRec = true;
			RightRec = false;
		}
		if(obj == rect4) {
			UpRec = false;
			LeftRec = false;
			DownRec = false;
			RightRec = true;
		}
		if(obj != ERROR) {
			program.remove(ERROR);
		}
		if(obj == escape) {
			program.switchToMenu();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//might want to set the values shown to be CAPS but just keep it constant.
		if(UpRec) {
			if((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122)) {
				Forward = e.getKeyChar();
				//might need a location call
				System.out.println(Forward);
				rect.setText(String.valueOf(Forward));
				UpRec = !UpRec;
			}
			else {
				box1 = true;
				program.add(ERROR);
			}
		}
		
		if(LeftRec) {
			if((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122)) {
				Left = e.getKeyChar();
				rect2.setText(String.valueOf(Left));
				LeftRec = !LeftRec;
			}
			else {
				box2 = true;
				program.add(ERROR);
			}
		}
		
		if(DownRec) {
			if((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122)) {
				Down = e.getKeyChar();
				rect3.setText(String.valueOf(Down));
				DownRec = !DownRec;
			}
			else {
				box3 = true;
				program.add(ERROR);
			}
		}
		
		if(RightRec) {
			if((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122)) {
				Right = e.getKeyChar();
				rect4.setText(String.valueOf(Right));
				RightRec = !RightRec;
			}
			else {
				box4 = true;
				program.add(ERROR);
			}
		}
		if(e.getKeyCode() == 27) {
			program.remove(ERROR);
		}
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
