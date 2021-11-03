import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class SettingPane extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 			
	private GButton rect;
	private GButton rect2;
	private GButton rect3;
	private GButton rect4;
	private final int BUTTON_SIZE_X = 300;
	private final int BUTTON_SIZE_Y = 200;
	private final int BUTTON_POS_Y = 70;

	//TODO we need WASD editing, audio.
	public SettingPane(MainApplication app) {
		super();
		program = app;
		rect = new GButton("W", 259, BUTTON_POS_Y, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		rect2 = new GButton("A", 259, BUTTON_POS_Y+45, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		rect3 = new GButton("S", 259, BUTTON_POS_Y+90, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		rect4 = new GButton("D", 259, BUTTON_POS_Y+135, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
	}

	@Override
	public void showContents() {
		program.add(rect);
		program.add(rect2);
		program.add(rect3);
		program.add(rect4);
	}

	@Override
	public void hideContents() {
		program.remove(rect);
		program.remove(rect2);
		program.remove(rect3);
		program.remove(rect4);
	}
	
	public void mousePressed(MouseEvent e) {
		System.out.print(e.getX());
		System.out.println();
		System.out.print(e.getY());
		System.out.println();
	}
}
/*
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToMenu();
		}
	}
}
*/