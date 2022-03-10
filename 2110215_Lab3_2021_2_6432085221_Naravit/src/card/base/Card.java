package card.base;

//You CAN modify the first line
public abstract class Card implements Cloneable {	
	private String name;
	private int bloodCost;
	private String flavorText;
	/// You can modify code below ///
	public Card(String name, String flavorText, int bloodCost) {
		this.name = name;
		this.flavorText = flavorText;
		this.bloodCost = bloodCost<0? 0:bloodCost;
	}
		
	public abstract String toString();
	
	public String getName() {
		return this.name;
	}

	public int getBloodCost() {
		return this.bloodCost;
	}

	public String getFlavorText() {
		return this.flavorText;
	}
	
	/// You can modify code above ///
	
	public boolean equals(UnitCard other) {
		return this.getName().equals(other.getName());
	}
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  

	
}