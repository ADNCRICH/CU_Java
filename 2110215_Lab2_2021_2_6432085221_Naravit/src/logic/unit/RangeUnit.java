package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit{

	public RangeUnit(int startColumn, int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		this.hp = 2;
	}
	
	@Override
	public void attack(ArrayList<BaseUnit> targetPieces) {
		for(BaseUnit x:targetPieces) {
			if(x.getColumn() == this.getColumn()) {
				if((isWhite()==true && this.getRow()+1 == x.getRow()) || isWhite()==false && this.getRow()-1 == x.getRow())
				x.setHp(x.getHp()-this.power);
				System.out.println(this.getName() + " attacks " + x.getName());
			}
		}
	}

}
