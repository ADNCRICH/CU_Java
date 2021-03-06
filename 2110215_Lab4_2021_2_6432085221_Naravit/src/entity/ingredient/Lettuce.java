package entity.ingredient;

import entity.base.Choppable;
import entity.base.Ingredient;

public class Lettuce extends Ingredient implements Choppable {
	private boolean chopState;
	
	public Lettuce() {
		super("Lettuce");
		setChopState(false);
		setEdible(true);
	}

	public boolean isChopped() {
		return chopState;
	}

	public void setChopState(boolean chopState) {
		this.chopState = chopState;
	}

	@Override
	public void chop() {
		if(!isChopped()) {
			setChopState(true);
			this.setName("Chopped Lettuce");
		}
	}
		
}
