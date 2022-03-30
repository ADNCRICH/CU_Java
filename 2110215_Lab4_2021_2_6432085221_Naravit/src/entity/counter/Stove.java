package entity.counter;

import entity.base.Item;
import entity.base.Updatable;
import entity.container.Pan;
import logic.Player;


public class Stove extends Counter implements Updatable {
	public Stove() {
		setName("Stove");
	}
	
	public Stove(Item content) {
		setName("Stove");
		setPlacedContent(content);
	}
	
	public void interact(Player p) {
		if(!isPlacedContentEmpty())
			super.interact(p);
		else if(p.getHoldingItem() instanceof Pan)
			super.interact(p);
	}
	
	public void update() {
		if(getPlacedContent() instanceof Pan)
			((Pan)getPlacedContent()).cook();
	}
}
