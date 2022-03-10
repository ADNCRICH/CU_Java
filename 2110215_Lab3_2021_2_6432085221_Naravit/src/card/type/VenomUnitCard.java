package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class VenomUnitCard extends UnitCard {
	
	public VenomUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name, flavorText, bloodCost, power, health);
	}
	
	public int dead(Player player) {
		player.takeDamage(getPower());
		return getPower();
	}

	@Override
	public int attackUnit(UnitCard u) {
		// TODO Auto-generated method stub
		int re = u.getHealth();
		u.setHealth(0);
		return re;
	}
}
