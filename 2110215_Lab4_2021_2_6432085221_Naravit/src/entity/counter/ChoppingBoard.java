package entity.counter;

import entity.base.Choppable;
import entity.base.Ingredient;
import logic.Player;

public class ChoppingBoard extends Counter {
	public ChoppingBoard() {
		setName("Chopping Board");
	}

	public void interact(Player p) {
		if(!isPlacedContentEmpty()) {
			super.interact(p);
			if(getPlacedContent() instanceof Choppable)
				((Choppable)getPlacedContent()).chop();
		}else if(p.getHoldingItem() instanceof Ingredient) {
			super.interact(p);
			if(getPlacedContent() instanceof Choppable)
				((Choppable)getPlacedContent()).chop();
		}		
	}
}
