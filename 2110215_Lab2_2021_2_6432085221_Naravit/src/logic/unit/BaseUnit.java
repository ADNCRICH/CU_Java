package logic.unit;

import java.util.ArrayList;

public class BaseUnit {
	private int row, column;
	private boolean isWhite;
	private String name;
	protected int hp, power;
	protected boolean isFlying;

	public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
		this.setColumn(startColumn);
		this.setRow(startRow);
		this.isWhite = isWhite;
		this.name = name;
		this.power = 1;
		this.hp = 2;
		this.isFlying = false;
	}

	public boolean move(int direction) {
		if((direction == 0 && this.row == 4)||(direction == 1 && this.column == 4)||
		   (direction == 2 && this.row == 0)||(direction == 3 && this.column == 0)||
		   (direction < 0||direction > 3)) {
			return false;
		}
		if(direction == 0)
			setRow(getRow()+1);
		if(direction == 1)
			setColumn(getColumn()+1);
		if(direction == 2)
			setRow(getRow()-1);
		if(direction == 3)
			setColumn(getColumn()-1);
		return true;
	}
	public void attack(ArrayList<BaseUnit> targetPieces) {
		for(BaseUnit x:targetPieces) {
			if(x.isFlying() == false && x.getColumn() == this.column && x.getRow() == this.row) {
				x.setHp(x.getHp()-this.power);
				System.out.println(this.getName() + " attacks " + x.getName());
			}
		}
	}
	
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public boolean isFlying() {
		return isFlying;
	}

	public int getHp() {
		return hp;
	}

	public void setRow(int row) {
		row = (row < 0) ? 0 : (row > 4) ? 4 : row;
		this.row = row;
	}

	public void setColumn(int column) {
		column = (column < 0) ? 0 : (column > 4) ? 4 : column;
		this.column = column;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

}
