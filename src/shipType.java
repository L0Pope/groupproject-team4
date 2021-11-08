
public enum shipType {
	enemyShip, bossShip, playerShip;
	public String toSring() {
		switch(this){
		case enemyShip: return "enemyship";
		case bossShip: return "bossShip";
		case playerShip: return "playership";
		}
		return "n/a";
	}
}


