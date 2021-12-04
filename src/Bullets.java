import java.util.ArrayList;

import acm.graphics.GImage;

public class Bullets {
public ArrayList<Bullet>bullets;
	

	public Bullets() {
		bullets = new ArrayList<>();
	}
	
		
	public void update(){
		
		for(Bullet b : bullets) {
			b.update();
			//if(b.getY() ==   ) {
			//	remove
			//}
		}
		bullets.removeIf(b ->(b.isdead()));
	}
	

	
	
	public void addBullet(Bullet b) {
		bullets.add(b);
	//	b.add(playerShip);
	}
	
	
	//clearBullets will clear the entire bullet list
	public void clearBullet() {
		bullets.clear();
	}
		
	
	//check if each bullet falls within bounds.  If yes continue, if no remove from list and from canvas
	public void removeBulletsOutOfBounds(int minX, int maxX, int minY, int maxY) {
	
		for (int i = bullets.size()-1; i>=0; i++) {
			double x = bullets.get(i).getX();
			double y = bullets.get(i).getY();
			if(x < minX || x > maxX || y < minY || y > maxY) {
				
				
				//remove from canvas
				bullets.get(i).removeBullet();
				
				//remove from list
				bullets.remove(i);
				
			}
		
		}
		
	}
	
	


}
