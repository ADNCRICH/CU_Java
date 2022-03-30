package logic.rocks;

import logic.zombies.Zombie;

public class PoisonRock extends NormalRock {
	private int damageOverTime;
	
	public PoisonRock(int damage,int damageOverTime) {
		super(damage);
		setDamageOverTime(damageOverTime);
	}
	
	public int dealDamage(Zombie zombie) {
		zombie.setDecay(damageOverTime+zombie.getDecay());
		return super.dealDamage(zombie);
	}
	
	public String toString() {
		return "Poison Rock (" + getDamage() +", DoT = "+getDamageOverTime() +")";
	}
	
	public int getDamageOverTime() {
		return damageOverTime;
	}

	public void setDamageOverTime(int damageOverTime) {
		this.damageOverTime = damageOverTime<0? 0:damageOverTime;
	}
	

}
