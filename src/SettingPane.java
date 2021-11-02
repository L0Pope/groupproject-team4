import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class SettingPane extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 			
	private GButton rect;
	private final int BUTTON_SIZE_X = 300;
	private final int BUTTON_SIZE_Y = 200;

	public SettingPane(MainApplication app) {
		super();
		program = app;
		rect = new GButton("Hello", app.getWidth()/2-BUTTON_SIZE_X/2, app.getHeight()/2-BUTTON_SIZE_Y/2, BUTTON_SIZE_X, BUTTON_SIZE_Y);
		rect.setFillColor(Color.BLUE);
	}

	@Override
	public void showContents() {
		program.add(rect);
	}

	@Override
	public void hideContents() {
		program.remove(rect);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToMenu();
		}
	}
}
