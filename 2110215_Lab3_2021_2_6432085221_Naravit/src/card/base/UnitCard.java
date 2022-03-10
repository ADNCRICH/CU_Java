package card.base;



import player.Player;

//You CAN modify the first line
public abstract class UnitCard extends Card  {
	private int power;
	private int health;
	public UnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name, flavorText, bloodCost);
		setHealth(health);
		setPower(power);
	}
	
	public abstract int attackUnit(UnitCard u);
	
	public int attackPlayer(Player opponent) {
		/*
		 Hint:
			Use takeDamage(int)
			from Player class
		*/
		opponent.takeDamage(getPower());
		return getPower();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getName() + "\tCost: " + this.getBloodCost() +"\t(POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}


	public int getPower() {
		return power;
	}


	public int getHealth() {
		return health;
	}


	public void setPower(int power) {
		power = (power<0)? 0:power;
		this.power = power;
	}


	public void setHealth(int health) {
		health = (health<0)? 0:health;
		this.health = health;
	}
	

}
