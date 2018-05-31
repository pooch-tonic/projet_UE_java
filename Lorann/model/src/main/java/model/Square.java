package model;

import showboard.IPawn;

public class Square {
	private IPawn unit;
	
	public Square() {
		
	}
	
	public Square(IPawn unit) {
		this.setUnit(unit);
	}

	public IPawn getUnit() {
		return unit;
	}

	private void setUnit(IPawn unit) {
		this.unit = unit;
	}
	
	public boolean isEmpty() {
		if(this.getUnit() != null) {
			return false;
		} else {
			return true;
		}
	}
	
	public void setUnitIfEmpty(IPawn unit) {
		if(this.isEmpty()) {
			this.setUnit(unit);
		}
	}
	
	public void removeUnit() {
		if(!this.isEmpty()) {
			this.setUnit(null);
		}
	}
}
