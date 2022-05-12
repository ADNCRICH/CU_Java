package fighters.derived;

import fighters.base.Guardable;
import fighters.base.Unit;

public class Tank extends Unit implements Guardable{
	
	public Tank(int maxHealth, int speed, int defence, int location) {
		super("Tank", "t", maxHealth, speed, location, true);
		this.setDefense(defence);
	}
	
	public void guard() {
		this.setOnGuard(true);
	}
	
	public boolean move(int spaces) {
		this.setOnGuard(false);
		return super.move(spaces);
	}
}
