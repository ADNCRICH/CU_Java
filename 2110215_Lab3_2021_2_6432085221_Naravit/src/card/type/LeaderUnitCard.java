package card.type;

import card.base.UnitCard;

//You CAN modify the first line
public class LeaderUnitCard extends UnitCard {
	private int buffPower,buffHealth;
	public LeaderUnitCard(String name, String flavorText, int bloodCost, int power, int health, int buffPower, int buffHealth) {
		super(name, flavorText, bloodCost, power, health);
		setBuffHealth(buffHealth);
		setBuffPower(buffPower);
	}
	
	public int getBuffPower() {
		return buffPower;
	}

	public int getBuffHealth() {
		return buffHealth;
	}

	public void setBuffPower(int buffPower) {
		this.buffPower = buffPower<0? 0:buffPower;
	}

	public void setBuffHealth(int buffHealth) {
		this.buffHealth = buffHealth<0? 0:buffHealth;
	}

	@Override
	public String toString() {
		return super.getName() + " (POW: " + super.getPower() + ", HP: " + super.getHealth() + 
				" | POW Inc: "+ this.getBuffPower() + ", HP Inc: " + this.getBuffHealth() + ")";
	}
	
	@Override
	public int attackUnit(UnitCard u) {
		// TODO Auto-generated method stub
		int re = Math.min(u.getHealth(), getPower());
		u.setHealth(u.getHealth()-getPower());
		return re;
	}
	
	public void buffUnit(UnitCard[] alliesCard) {
		for(UnitCard c:alliesCard) {
			if(c == null)
				continue;
			c.setHealth(c.getHealth()+getBuffHealth());
			c.setPower(c.getPower()+getPower());
		}
	}

}