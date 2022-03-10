package card.type;

import card.base.UnitCard;

//You CAN modify the first line
public class DebuffUnitCard extends UnitCard {	
	private int debuffPower;
	public DebuffUnitCard(String name, String flavorText, int bloodCost, int power, int health, int debuffPower) {
		super(name, flavorText, bloodCost, power, health);
		setDebuffPower(debuffPower);
	}

	@Override
	public int attackUnit(UnitCard u) {
		// TODO Auto-generated method stub
		int re =Math.min(u.getHealth(), getPower());
		u.setHealth(u.getHealth()-getPower());
		u.setPower(u.getPower()-getDebuffPower());
		return re;
	}

	public int getDebuffPower() {
		return debuffPower;
	}

	public void setDebuffPower(int debuffPower) {
		this.debuffPower = debuffPower<0? 0:debuffPower;
	}	
	

	
}
