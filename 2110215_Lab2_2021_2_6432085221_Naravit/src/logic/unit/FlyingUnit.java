package logic.unit;

public class FlyingUnit extends BaseUnit {

	public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		this.isFlying = true;
		this.hp = 2;
	}
	
	@Override
	public boolean move(int direction) {
		int RR = getRow();
		int CC = getColumn();
		if(super.move(direction) && super.move(direction))
			return true;
		this.setColumn(CC);
		this.setRow(RR);
		return false;
	}
	
}
