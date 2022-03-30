package logic;

public class OrderItem {
	private Item item;
	private int itemAmount;
	
	public OrderItem(Item item, int itemAmount){
		setItem(item);
		setItemAmount(itemAmount);
	}
	
	public void increaseItemAmount(int amount) {
		setItemAmount((amount<0? 0:amount)+getItemAmount());
	}
	
	public int calculateTotalPrice() {
		return item.getPricePerPiece() * getItemAmount();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount<0? 0:itemAmount;
	}
}
