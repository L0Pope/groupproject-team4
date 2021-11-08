
public class healthSystem {
	private shipType typeShip;
	private int health;
	private boolean isDestroyed;
	
	public healthSystem(shipType typeShip, int health, boolean isDestroyed) {
		this.typeShip = typeShip;
		this.health = health;
		this.isDestroyed = isDestroyed;
	}
	
	public shipType getShipType() {
		return this.typeShip;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHealth() {
		return this.health;
	}
	public boolean isDestroyed() {
		return isDestroyed;
	}
	public void subtractHealth() {
		this.health -= 1;
		if(health == 0) {
			isDestroyed = true;
		}
	}
	
	public static void main(String[] args) {
		healthSystem somePlayerShip = new healthSystem(shipType.playerShip, 3, false);
		System.out.println("This test is going to test playerShip subtracting health!");
		somePlayerShip.subtractHealth();
		System.out.println("Health: " + somePlayerShip.getHealth());
		System.out.println("This test is going to test and see if the ships boolean is set to destroyed!");
		somePlayerShip.subtractHealth();
		somePlayerShip.subtractHealth();
		System.out.println("Is this destroyed?: " + somePlayerShip.isDestroyed());
	}
}
