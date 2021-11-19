import java.util.ArrayList;


public class Bullets  {

	
	private ArrayList<Bullet>bullets;
	

	public Bullets() {
		bullets = new ArrayList<>();
	}
	
		
	public void ß(){
		
		for(Bullet b : bullets) {
			b.update();
		}
		bullets.removeIf(b ->(b.isdead()));
	}

	public void addBullet(Bullet b) {
		bullets.add(b);
	}
	
	
	public void clearBullet() {
		bullets.clear();
	}
	
	
	
	//testing
	//public static void main(String[] args) {
		//Bullets b = new Bullets();
	
	//for (int i=0;  i<5; i++) {
		//b.addBullet(new Bullet(2.0,3.0,2.0,1));
		//b.update();
		//System.out.println(b.toString());	
		//}
//}
	

	
	
	
}

