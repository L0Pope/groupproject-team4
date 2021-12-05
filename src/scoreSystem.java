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
        this.score = score + (remainingHearts *10) + 20;
    }
	
	public void printInfo() {
		System.out.println("Score: " + getScore());
		System.out.println("Remaining Hearts: " + getRemainingHearts());
		System.out.println("Killed Enemies: " + getKilledEnemies());
	}
	public static void main(String args[]) {
		scoreSystem someGame = new scoreSystem(0,3,0);
		System.out.println("Going to test if killed enemies increments!");
		someGame.killedEnemyShip();
		someGame.calculateScore();
		someGame.printInfo();
		System.out.println("Going to test for 3 enemies killed + 2 remaining health");
		someGame.playerShipHit();
		someGame.killedEnemyShip();
		someGame.killedEnemyShip();
		someGame.calculateScore();
		someGame.printInfo();
	}
}
