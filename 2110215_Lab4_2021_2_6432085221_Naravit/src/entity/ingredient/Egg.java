package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;

public class Egg extends Ingredient implements Cookable {
	private int cookedPercentage;

	public Egg() {
		super("Egg");
		setCookedPercentage(0);
		// TODO Auto-generated constructor stub
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}

	@Override
	public void cook() {
		setCookedPercentage(getCookedPercentage() + 12);
		if (getCookedPercentage() <= 50) {
			setName("Raw Egg");
			setEdible(false);
		} else if (getCookedPercentage() <= 80) {
			setName("Sunny Side Egg");
			setEdible(true);
		} else if (getCookedPercentage() <= 100) {
			setName("Fried Egg");
			setEdible(true);
		} else {
			setName("Burnt Egg");
			setEdible(false);
		}
	}

	@Override
	public boolean isBurnt() {
		return getCookedPercentage() > 100;
	}

	public String toString() {
		return logic.StringUtil.formatNamePercentage(getName(), getCookedPercentage());
	}

}
