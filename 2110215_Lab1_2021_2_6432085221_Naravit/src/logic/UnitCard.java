package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public UnitCard(String n, int b, int p, int h, String f) {
		this.setName(n);
		this.setBloodCost(b);
		this.setHealth(h);
		this.setPower(p);
		this.flavorText = f;

	}

	public int getPower() {
		return this.power;
	}

	public int getHealth() {
		return this.health;
	}

	public String getName() {
		return this.name;
	}
	
	public int getBloodCost() {
		return this.bloodCost;
	}
	
	public String getFlavorText() {
		return this.flavorText;
	}

	public void setName(String name) {
		if (name.isBlank())
			name = "Creature";
		this.name = name;
	}

	public void setBloodCost(int bloodCost) {
		if (bloodCost < 0)
			bloodCost = 0;
		this.bloodCost = bloodCost;
	}

	public void setPower(int Power) {
		if (Power < 0)
			Power = 0;
		this.power = Power;
	}

	public void setHealth(int health) {
		if (health < 1)
			health = 1;
		this.health = health;
	}
	
	public void setFlavorText(String s) {
		this.flavorText = s;
	}
	
	public boolean equals(UnitCard other) {
		if(this.getName().equals(other.getName()))
			return true;
		return false;
	}
	
	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
}
