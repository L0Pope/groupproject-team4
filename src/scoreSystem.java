import javax.print.attribute.standard.PrinterInfo;

public class scoreSystem {
	private int score, remainingHearts, killedEnemies;
	
	
	public scoreSystem (int score, int remainingHearts, int killedEnemies) {
		this.score = score;
		this.remainingHearts = remainingHearts;
		this.killedEnemies = killedEnemies;
	}
	
	public int getScore() {
		return this.score;
	}
	public int getRemainingHearts() {
		return this.remainingHearts;
	}
	public int getKilledEnemies() {
		return this.killedEnemies;
	}
	public void killedEnemyShip() {
		this.killedEnemies += 1;
	}
	public void playerShipHit() {
		this.remainingHearts -=1;
	}
	public void calculateKilledEnemy(int score, int remainingHearts) {
        this.score = score + (remainingHearts *300) + 100;
    }
	
	public void printInfo() {
		System.out.println("Score: " + getScore());
		System.out.println("Remaining Hearts: " + getRemainingHearts());
		System.out.println("Killed Enemies: " + getKilledEnemies());
	}
	public static void main(String args[]) {
		
	}
}
