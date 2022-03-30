package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {
	private boolean chopState;
	private int cookedPercentage;

	public Meat() {
		super("Meat");

	}

	public boolean getChopState() {
		return chopState;
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setChopState(Boolean chopState) {
		this.chopState = chopState;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}

	@Override
	public void cook() {
		setCookedPercentage(getCookedPercentage()+(isChopped()? 15:10));
		if (getCookedPercentage() <= 50 && !isChopped()) {
			setName("Raw Meat");
			setEdible(false);
		} else if (getCookedPercentage() <= 80) {
			setName(isChopped() ? "Raw Burger" : "Medium Rare Steak");
			setEdible(!isChopped());
		} else if (getCookedPercentage() <= 100) {
			setName(isChopped() ? "Cooked Burger" : "Well Done Steak");
			setEdible(true);
		} else {
			setName(isChopped() ? "Burnt Burger" : "Burnt Steak");
			setEdible(false);
		}
	}
	
	@Override
	public String toString() {
		return StringUtil.formatNamePercentage(getName(), getCookedPercentage());
	}

	@Override
	public boolean isBurnt() {
		return getCookedPercentage() > 100;
	}

	@Override
	public void chop() {
		if(!isChopped() && getCookedPercentage() == 0) {
			setChopState(true);
			setName("Minced Meat");
		}

	}

	@Override
	public boolean isChopped() {
		return this.chopState;
	}

}
