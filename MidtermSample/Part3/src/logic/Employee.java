package logic;

public abstract class Employee {
	protected String Name;
	protected int id;
	protected int baseSalary;
	protected int bonus;
	
	public Employee(String name, int id,int baseSalary) {
		setName(name);
		setId(id);
		setBaseSalary(baseSalary);
		setBonus(0);
	}
	
	public abstract int computeSalary();
	
	public abstract String getDescription();
	
	public String getName() {
		return Name ;
	}
	public int getId() {
		return id;
	}
	public int getBaseSalary() {
		return baseSalary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBaseSalary(int baseSalaly) {
		this.baseSalary = baseSalaly<0? 0:baseSalaly;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus<0? 0:bonus;
	}
	
	
}
