import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program;
								
	private GButton rect;
	private GButton rect2;
	private GButton rect3;
	private GButton rect4;
	private final int BUTTON_SIZE_X = 200;
	private final int BUTTON_SIZE_Y = 100;
	private final int STATIC_ADDER = 50;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		rect = new GButton("Play", app.getWidth()/2-BUTTON_SIZE_X/2, app.getHeight()/2-BUTTON_SIZE_Y/2 - (3*STATIC_ADDER), BUTTON_SIZE_X, BUTTON_SIZE_Y);
		rect.setFillColor(Color.GREEN);
		rect2 = new GButton("Setting", app.getWidth()/2-BUTTON_SIZE_X/2, app.getHeight()/2-BUTTON_SIZE_Y/2- (STATIC_ADDER*.5), BUTTON_SIZE_X, BUTTON_SIZE_Y);
		rect2.setFillColor(Color.BLUE);
		rect3 = new GButton("High Score", app.getWidth()/2-BUTTON_SIZE_X/2, app.getHeight()/2-BUTTON_SIZE_Y/2 + (STATIC_ADDER*2), BUTTON_SIZE_X, BUTTON_SIZE_Y);
		rect3.setFillColor(Color.PINK);
		rect4 = new GButton("Quit", app.getWidth()/2-BUTTON_SIZE_X/2, app.getHeight()/2-BUTTON_SIZE_Y/2 + (STATIC_ADDER*4.5), BUTTON_SIZE_X, BUTTON_SIZE_Y);
		rect4.setFillColor(Color.CYAN);
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
		program.removeAll();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		System.out.println(e.getX());
		System.out.println(e.getY());
		if (obj == rect) {
			program.switchToSome();
		}
		if (obj == rect2) {
			program.switchToSetting();
		}
		if (obj == rect3) {
			program.switchToHighScore();
		}
		if (obj == rect4) {
			System.exit(0);
		}
	}
}
