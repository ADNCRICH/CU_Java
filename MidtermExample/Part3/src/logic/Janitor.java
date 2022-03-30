package logic;

public class Janitor extends Employee {
	private String area;
	
	public Janitor(String name, int id,String area) {
		super(name, id, 15);
		setArea(area);
	}

	@Override
	public int computeSalary() {
		return BackEndAPI.calculateMonthlySalary(baseSalary, bonus, 30);
	}
	@Override
	public String getDescription() {
		return BackEndAPI.getJanitorDescription(id, Name, area, bonus);
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
