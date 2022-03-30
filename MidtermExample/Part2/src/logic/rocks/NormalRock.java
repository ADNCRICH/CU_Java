package logic.rocks;

import logic.zombies.Zombie;

public class NormalRock {
	protected int damage;
	
	public NormalRock(int damage) {
		setDamage(damage);
	}
	
	public int dealDamage(Zombie zombie) {
		int dmg = zombie.getDefense()>getDamage()? 0:getDamage()-zombie.getDefense();
		zombie.setHealth(zombie.getHealth()-dmg);
		return dmg;
	}
	
	public String toString() {
		return "Normal Rock (" + getDamage() + ")";
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage<0? 0:damage;
	}

}
