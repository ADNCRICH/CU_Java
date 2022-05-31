package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Wizard extends Unit implements Attackable {

	public Wizard(int maxHealth, int speed, int power, int location) {
		// TODO Auto-generated constructor stub
		super("Wizard", "w", maxHealth, speed, location, true);
		setPower(power);
		setRange(2);
	}

	@Override
	public int attack(Unit e) {
		// TODO Auto-generated method stub
		if(sameTeam(e) || !BattleUtils.validRange(getRange(), getLocation(), e.getLocation()))
			return -1;
		return getPower();
	}
	

}
