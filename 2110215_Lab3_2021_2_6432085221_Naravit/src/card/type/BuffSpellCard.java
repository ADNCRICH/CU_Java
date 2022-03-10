package card.type;

import card.base.SpellCard;
import card.base.UnitCard;

//You CAN modify the first line
public class BuffSpellCard extends SpellCard {
	public int powerIncrease;
	public BuffSpellCard(String name, String flavorText, int bloodCost, 
			boolean isBurstSpeed, int powerIncrease) {
		super(name, flavorText, bloodCost, isBurstSpeed);
		setPowerIncrease(powerIncrease);
	}
	public void castSpell(UnitCard unitCard) {
		unitCard.setPower(unitCard.getPower()+getPowerIncrease());
	}
	public int getPowerIncrease() {
		return powerIncrease;
	}
	public void setPowerIncrease(int powerIncrease) {
		this.powerIncrease = powerIncrease<1? 1:powerIncrease ;
	}

}