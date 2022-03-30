package entity.container;

import entity.base.Container;
import entity.base.Ingredient;

public class Dish extends Container {
	private int dirty;

	public Dish() {
		super("Dish", 4);
		setDirty(0);
	}

	public Dish(int dirty) {
		super("Dish", 4);
		setDirty(dirty);
	}

	public boolean isDirty() {
		return dirty > 0;
	}

	@Override
	public boolean verifyContent(Ingredient i) {
		return !isDirty() && i.isEdible();
	}

	public void clean(int amount) {
		setDirty(getDirty() - amount);
	}

	public String toString() {
		if(isDirty())
			return getName() + " (" + String.valueOf(getDirty()) + "%)";
		else
			return super.toString();
	}

	public int getDirty() {
		return dirty;
	}

	public void setDirty(int dirty) {
		this.dirty = dirty < 0 ? 0 : dirty;
		this.setName(isDirty() ? "Dirty Dish" : "Dish");
	}
}
