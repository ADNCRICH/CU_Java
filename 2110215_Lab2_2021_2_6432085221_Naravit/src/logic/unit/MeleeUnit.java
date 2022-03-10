package logic.unit;

public class MeleeUnit extends BaseUnit {

	public MeleeUnit(int startColumn, int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		this.power = 2;
		this.hp = 5;
	}
	
}
