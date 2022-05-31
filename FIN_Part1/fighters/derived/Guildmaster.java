package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Guardable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Guildmaster extends Unit implements Guardable, Attackable {

	public Guildmaster(int maxHealth, int speed, int power, int defense, int location) {
		// TODO Auto-generated constructor stub
		super("Guildmaster", "G", maxHealth, speed, location, false);
		setDefense(defense);
		setPower(power);
		setRange(1);
	}

	@Override
	public int attack(Unit e) {
		// TODO Auto-generated method stub
		if(sameTeam(e) || !BattleUtils.validRange(getRange(), getLocation(), e.getLocation()))
			return -1;
		return BattleUtils.calculateDamage(getPower(), e);
	}

	@Override
	public void guard() {
		// TODO Auto-generated method stub

	}
	public boolean move(int spaces) {
		return super.move(-1);
	}

}
